package com.fintech.service;

import com.fintech.PaymentStatus;
import com.fintech.entity.ExpensesEntity;
import com.fintech.entity.UserAccountEntity;
import com.fintech.exception.NotFoundException;
import com.fintech.repository.ExpensesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpensesService {
    private static final String ID_NOT_FOUND = "Id not found";
    private static final String TITLE_NOT_FOUND = "Title not found";

    private final ExpensesRepository expensesRepository;
    private UserAccountEntity userAccountEntity;

    public void addNewRecurringPayment(ExpensesEntity expensesEntity,  LocalDate date){
        while (LocalDate.now().equals(date)){
            BigDecimal newBalance = userAccountEntity.getBalance().subtract(expensesEntity.getValor());
            userAccountEntity.setBalance(newBalance);
            expensesEntity.setStatus(PaymentStatus.PAID);
            expensesRepository.save(expensesEntity);
        }
    }

    public ExpensesEntity doATransfer(ExpensesEntity expensesEntity){
        BigDecimal newBalance = userAccountEntity.getBalance().subtract(expensesEntity.getValor());
        userAccountEntity.setBalance(newBalance);
        return expensesRepository.save(expensesEntity);
    }

    public ExpensesEntity getExpenseById(Long id){
        return expensesRepository.findById(id).orElseThrow(() -> new NotFoundException(ID_NOT_FOUND));
    }

    public ExpensesEntity getExpenseByTitle(String title){
        return expensesRepository.findByTitle(title).orElseThrow(() -> new NotFoundException(TITLE_NOT_FOUND));
    }

//    public ExpensesEntity getExpenseByDate(LocalDateTime date){
//        return expensesRepository.findByDate(date).orElseThrow(() -> new NotFoundException(TITLE_NOT_FOUND));
//    }

    public void deleteById(Long id){
        Optional<ExpensesEntity> expense = expensesRepository.findById(id);
        if(expense.isPresent() && (getExpenseById(id).getStatus()== PaymentStatus.NOT_PAID)) {
            throw new RuntimeException("Expenses with UNPAID status cannot be excluded");
        }
        expensesRepository.deleteById(id);
    }
}
