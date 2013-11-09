package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.soap.SoapFunction;
import com.flagleader.repository.tree.Envionment;
import java.util.Iterator;

public class FunctionSoapToken extends MemberToken
  implements IStatementToken
{
  public FunctionSoapToken(FunctionSoapToken paramFunctionSoapToken)
  {
    super(paramFunctionSoapToken);
  }

  public FunctionSoapToken()
  {
  }

  public FunctionSoapToken(String paramString)
  {
    super(paramString);
  }

  public IElement deepClone()
  {
    return new FunctionSoapToken(this);
  }

  protected Iterator e()
  {
    String str = getValueType();
    return getEnvionment().getAcceptElements(new o(this, str));
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    String str = getValueType();
    if ((paramObject instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if ((((localIBusinessObjectEditen instanceof SoapFunction)) || ((localIBusinessObjectEditen instanceof ISubFunction))) && ((str == null) || (str.length() == 0) || (localIBusinessObjectEditen.getJavaType().d(str))))
        return true;
    }
    return false;
  }

  public String getName()
  {
    return "FunctionSoapToken";
  }

  protected String i()
  {
    return getLocalString("selectSoapFunction.text");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.FunctionSoapToken
 * JD-Core Version:    0.6.0
 */