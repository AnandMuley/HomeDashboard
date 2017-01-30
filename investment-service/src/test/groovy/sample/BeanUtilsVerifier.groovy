package sample

import com.abm.investments.dtos.InvestmentDto
import com.abm.investments.model.Investment
import org.springframework.beans.BeanUtils

class BeanUtilsVerifier {

    public static void main(String[] args) {
        InvestmentDto investmentDto = new InvestmentDto(UUID.randomUUID().toString(),"Ronnie")
        Investment investment = new Investment()
        BeanUtils.copyProperties(investmentDto,investment,"id")
        println investment
    }

}
