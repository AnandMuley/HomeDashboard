package com.propertymanager.services

import com.propertymanager.domain.Investment
import com.propertymanager.repositories.InvestmentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InvestmentService(@Autowired investmentRepository: InvestmentRepository) {

  def add(investment: Investment): Investment = {
    investmentRepository.save(investment)
  }

}
