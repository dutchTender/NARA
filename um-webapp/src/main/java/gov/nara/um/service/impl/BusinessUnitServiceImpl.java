package gov.nara.um.service.impl;

import gov.nara.common.persistence.service.AbstractService;
import gov.nara.um.persistence.dao.IBusinessUnitDao;
import gov.nara.um.persistence.dao.IUserJpaDao;
import gov.nara.um.persistence.model.BusinessUnit;
import gov.nara.um.persistence.model.User;
import gov.nara.um.service.IBusinessUnitService;
import gov.nara.um.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
public class BusinessUnitServiceImpl extends AbstractService<BusinessUnit> implements IBusinessUnitService {

    @Autowired
    private IBusinessUnitDao dao;

    @Autowired
    private IUserJpaDao userDao;


    public BusinessUnitServiceImpl() {
        super();
    }

    // API
    // find

    @Override
    @Transactional(readOnly = true)
    public BusinessUnit findByName(final String name) {
        return dao.findByName(name);
    }

    // other

    // add user
    public BusinessUnit addUser(final String unitId, final String userId){

       Optional <BusinessUnit> businessUnitOptional =  dao.findById(Long.valueOf(unitId));
       BusinessUnit businessUnit =  businessUnitOptional.get();
       Optional <User> userOptional = userDao.findById(Long.valueOf(userId));
       User user = userOptional.get();

       if(businessUnit != null && user != null){
           businessUnit.addUser(user);
           user.setBusinessUnit(businessUnit);
           dao.save(businessUnit);
           userDao.save(user);
       }

       return businessUnit;
    }


    public BusinessUnit removerUser(String unitId, String userId) {

        Optional <BusinessUnit> businessUnitOptional =  dao.findById(Long.valueOf(unitId));
        BusinessUnit businessUnit =  businessUnitOptional.get();
        Optional <User> userOptional = userDao.findById(Long.valueOf(userId));
        User user = userOptional.get();

        if(businessUnit != null && user != null){
            businessUnit.removeUser(user);
            user.setBusinessUnit(null);
            dao.save(businessUnit);
            userDao.save(user);
        }

        return businessUnit;
    }


    // remove user



    // Spring

    @Override
    protected final IBusinessUnitDao getDao() {
        return dao;
    }

    @Override
    protected JpaSpecificationExecutor<BusinessUnit> getSpecificationExecutor() {
        return dao;
    }
}
