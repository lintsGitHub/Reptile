package priv.lint.policyreptaile.Service;

import org.springframework.beans.factory.annotation.Autowired;
import priv.lint.policyreptaile.DAO.PolicyJPA;
import priv.lint.policyreptaile.Entity.PolicyRaw;

import java.util.List;

public class PolicyService {
    @Autowired
    private PolicyJPA policyJPA;

    public PolicyRaw addPolicy(PolicyRaw policyRaw){
       return policyJPA.save(policyRaw) ;
    }

    public void addPolicyAll(List<PolicyRaw> list){
        policyJPA.saveAll(list);
    }

}
