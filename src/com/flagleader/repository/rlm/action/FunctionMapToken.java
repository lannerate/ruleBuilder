package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.db.TableFunction;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.tree.Envionment;
import java.util.Iterator;

public class FunctionMapToken extends MemberToken
  implements IStatementToken
{
  public FunctionMapToken(FunctionMapToken paramFunctionMapToken)
  {
    super(paramFunctionMapToken);
  }

  public FunctionMapToken()
  {
  }

  public FunctionMapToken(String paramString)
  {
    super(paramString);
  }

  public IElement deepClone()
  {
    return new FunctionMapToken(this);
  }

  protected Iterator e()
  {
    String str = getValueType();
    return getEnvionment().getAcceptElements(new m(this, str));
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
      else if (((localIBusinessObjectEditen instanceof ISubFunction)) && (!(((ISubFunction)localIBusinessObjectEditen).getRootMember() instanceof BOContainerGroup)) && ((str == null) || (str.length() == 0) || (localIBusinessObjectEditen.getJavaType().d(str))))
        return true;
    }
    return false;
  }

  public String getName()
  {
    return "FunctionMapToken";
  }

  protected String i()
  {
    return getLocalString("selectMapFunction.text");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.FunctionMapToken
 * JD-Core Version:    0.6.0
 */