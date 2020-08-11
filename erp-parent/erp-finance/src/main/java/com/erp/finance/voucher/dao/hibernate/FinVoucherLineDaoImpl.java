/*
 * Copyright 2020-2021 redragon.dongbin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.erp.finance.voucher.dao.hibernate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.framework.annotation.Cache;
import com.framework.annotation.Permissions;
import com.framework.annotation.Permissions.PermissionType;
import com.framework.annotation.SqlParam;
import com.framework.dao.DaoSupport;
import com.framework.dao.model.Pages;
import com.framework.util.DaoUtil;
import com.erp.finance.voucher.dao.FinVoucherLineDao;
import com.erp.finance.voucher.dao.model.FinVoucherLine;
import com.erp.finance.voucher.dao.model.FinVoucherLineCO;

@Repository
public class FinVoucherLineDaoImpl implements FinVoucherLineDao{ 

    //注入DaoSupport工具类
    @Autowired
    private DaoSupport daoSupport;
    
    @Override
    public void insertDataObject(FinVoucherLine obj) {
        this.daoSupport.insertDataTransaction(obj);
    }

    @Override
    public void updateDataObject(FinVoucherLine obj) {
        this.daoSupport.updateDataTransaction(obj);
    }
    
    @Override
    public void insertOrUpdateDataObject(FinVoucherLine obj) {
        this.daoSupport.insertOrUpdateDataTransaction(obj);
    }

    @Override
    public void deleteDataObject(FinVoucherLine obj) {
        this.daoSupport.deleteDataTransactionJPA(obj);
    }

    @Override
    public List<FinVoucherLine> getDataObjects() {
        return this.daoSupport.getDataAllObject(FinVoucherLine.class);
    }

    @Override
    public FinVoucherLine getDataObject(int id) {
        return (FinVoucherLine)this.daoSupport.getDataObject(FinVoucherLine.class, id);
    }
    
    @Override
    public FinVoucherLine getDataObject(String code) {
        return null;
    }
    
    @Override
    public List<FinVoucherLine> getDataObjects(FinVoucherLineCO paramObj) {
        return null;
    }
    
    @Override
    public List<FinVoucherLine> getDataObjects(Pages pages) {
        return null;
    }
    
    @Override
    public List<FinVoucherLine> getDataObjects(Pages pages, FinVoucherLineCO paramObj) {
        return null;
    }

    @Override
    public List<Map<String, Object>> getDataObjectsArray(Pages pages, FinVoucherLineCO paramObj) {
        return null;
    }
    
    @Override
    @Permissions(PermissionType.OWN)
    public List<FinVoucherLine> getDataObjectsForDataAuth(@SqlParam String dataAuthSQL, Pages pages, FinVoucherLineCO paramObj) {
        return null;
    }
    
    @Override
    public List<FinVoucherLine> getFinVoucherLineListByVoucherHeadCode(String voucherHeadCode) {
        String sql = "select l.* from fin_voucher_line l where voucher_head_code = :voucherheadcode order by l.voucher_line_id";
        
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("voucherheadcode", voucherHeadCode);
        
        Map<String, Class<?>> entity = new HashMap<String, Class<?>>();
        entity.put("l", FinVoucherLine.class);
        
        return this.daoSupport.selectDataSql(sql, entity, args);
    }
    
    @Override
    public void deleteFinVoucherLineByVoucherHeadCode(String voucherHeadCode) {
        String sql = "delete from fin_voucher_line where voucher_head_code = :voucherheadcode";
        
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("voucherheadcode", voucherHeadCode);
        
        this.daoSupport.executeSQLTransaction(sql, args);
    }
    
    @Override
    public BigDecimal getFinVoucherAmountByVoucherHeadCode(String voucherHeadCode) {
        String sql = "select sum(l.dr_amount) from fin_voucher_line l where l.voucher_head_code = :voucherheadcode";
        
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("voucherheadcode", voucherHeadCode);
        
        List<BigDecimal> list = this.daoSupport.selectDataSqlCount(sql, args);
        if(list.size()>0) {
            return list.get(0);
        }
        
        return new BigDecimal(0D);
    }
    
}
