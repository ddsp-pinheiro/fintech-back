package com.fintech.service;

import com.fintech.entity.CardEntity;
import com.fintech.entity.UserAccountEntity;
import com.fintech.exception.NotFoundException;
import com.fintech.repository.CardRepository;
import com.fintech.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
    private static final String NUMBER_NOT_FOUND = "We couldn't found any card with this number";
    private static final String ID_NOT_FOUND = "Id not found";

    private final CardRepository cardRepository;
    private final UserAccountRepository userAccountRepository;
    private UserAccountEntity userAccountEntity;
    private final UserAccountService userAccountService;

    public CardEntity addNewCard(CardEntity cardEntity, Long cpf ){
        if (cardRepository.findByNumber(cardEntity.getNumber()).isPresent()){
            throw new DuplicateKeyException("This card already exists");
        }
        var cardOwner = userAccountService.getByCpf(cpf);
        List<CardEntity> cardEntities = new ArrayList<>();
        cardEntity.setUser(cardOwner.getId());
        cardEntities.add(cardEntity);
        return cardRepository.save(cardEntity);
    }

    public CardEntity getById(Long id){
        return cardRepository.findById(id).orElseThrow(() -> new NotFoundException(ID_NOT_FOUND));
    }

    public CardEntity getByNumber(String number){
        return cardRepository.findByNumber(number).orElseThrow(() -> new NotFoundException(NUMBER_NOT_FOUND));
    }

    public List<CardEntity> getCards(Long id){
        var card = cardRepository.findAllByUser(id);
        if (!card.isEmpty()) {
            return card;
        }
        throw new RuntimeException("Id of user card not found");
    }

    public void deleteById(Long id){
        cardRepository.deleteById(id);
    }
}
