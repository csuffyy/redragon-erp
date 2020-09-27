/*
 * Copyright 2020-2021 redragon.dongbin
 *
 * This file is part of redragon-erp/赤龙ERP.

 * redragon-erp/赤龙ERP is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.

 * redragon-erp/赤龙ERP is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with redragon-erp/赤龙ERP.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.erp.finance.ar.invoice.service;

import java.util.List;

import com.erp.finance.ar.invoice.dao.model.ArInvoiceHead;
import com.erp.finance.ar.invoice.dao.model.ArInvoiceHeadCO;
import com.framework.api.DaoCRUDIF;
import com.framework.dao.model.Pages;

public interface ArInvoiceHeadService extends DaoCRUDIF<ArInvoiceHead, ArInvoiceHeadCO> {
    
    //修改审批状态
    public abstract void updateApproveStatus(String code, String approveStatus);
    
    //获取收款单数量
    public abstract int getArInvoiceHeadNum(String startDate, String endDate);
    
}
