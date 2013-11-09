package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.db.TableFunction;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.tree.Envionment;
import java.util.Iterator;

public class FunctionDBToken extends MemberToken
  implements IStatementToken
{
  public FunctionDBToken(FunctionDBToken paramFunctionDBToken)
  {
    super(paramFunctionDBToken);
  }

  public FunctionDBToken()
  {
  }

  public FunctionDBToken(String paramString)
  {
    super(paramString);
  }

  public IElement deepClone()
  {
    return new FunctionDBToken(this);
  }

  protected Iterator e()
  {
    String str = getValueType();
    return getEnvionment().getAcceptElements(new k(this, str));
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    String str = getValueType();
    if ((paramObject instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if ((localIBusinessObjectEditen instanceof TableFunction))
      {
        if ((str == null) || (str.length() == 0) || (localIBusinessObjectEditen.getJavaType().d(str)))
          return true;
      }
      else if (((localIBusinessObjectEditen instanceof ISubFunction)) && ((str == null) || (str.length() == 0) || (localIBusinessObjectEditen.getJavaType().d(str))))
        return true;
    }
    return false;
  }

  public String getName()
  {
    return "FunctionDBToken";
  }

  protected String i()
  {
    return getLocalString("selectDBFunction.text");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.FunctionDBToken
 * JD-Core Version:    0.6.0
 */