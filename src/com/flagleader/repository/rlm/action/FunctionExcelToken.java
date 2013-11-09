package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.excel.ExcelFunction;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.tree.Envionment;
import java.util.Iterator;

public class FunctionExcelToken extends MemberToken
  implements IStatementToken
{
  public FunctionExcelToken(FunctionExcelToken paramFunctionExcelToken)
  {
    super(paramFunctionExcelToken);
  }

  public FunctionExcelToken()
  {
  }

  public FunctionExcelToken(String paramString)
  {
    super(paramString);
  }

  public IElement deepClone()
  {
    return new FunctionExcelToken(this);
  }

  protected Iterator e()
  {
    String str = getValueType();
    return getEnvionment().getAcceptElements(new l(this, str));
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    String str = getValueType();
    if ((paramObject instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if ((((localIBusinessObjectEditen instanceof ExcelFunction)) || ((localIBusinessObjectEditen instanceof ISubFunction))) && ((str == null) || (str.length() == 0) || (localIBusinessObjectEditen.getJavaType().d(str))))
        return true;
    }
    return false;
  }

  public String getName()
  {
    return "FunctionExcelToken";
  }

  protected String i()
  {
    return getLocalString("selectExcelFunction.text");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.FunctionExcelToken
 * JD-Core Version:    0.6.0
 */