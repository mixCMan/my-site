package cn.luischen.service.relation.impl;

import cn.luischen.dao.RelationShipDaoMapper;
import cn.luischen.service.relation.RelationShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by winterchen on 2018/4/30.
 */
@Service
public class RelationShipServiceImpl implements RelationShipService {

    @Autowired
    private RelationShipDaoMapper relationShipDaoMapper;


}
