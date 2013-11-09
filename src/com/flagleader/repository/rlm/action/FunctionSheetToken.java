package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.TableFunction;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.tree.Envionment;
import java.util.Iterator;

public class FunctionSheetToken extends MemberToken
  implements IStatementToken
{
  public FunctionSheetToken(FunctionSheetToken paramFunctionSheetToken)
  {
    super(paramFunctionSheetToken);
  }

  public FunctionSheetToken()
  {
  }

  public FunctionSheetToken(String paramString)
  {
    super(paramString);
  }

  public IElement deepClone()
  {
    return new FunctionSheetToken(this);
  }

  protected Iterator e()
  {
    String str = getValueType();
    return getEnvionment().getAcceptElements(new n(this, str));
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
      else if (((localIBusinessObjectEditen instanceof ISubFunction)) && (!(((ISubFunction)localIBusinessObjectEditen).getRootMember() instanceof DBModel)) && ((str == null) || (str.length() == 0) || (localIBusinessObjectEditen.getJavaType().d(str))))
        return true;
    }
    return false;
  }

  public String getName()
  {
    return "FunctionSheetToken";
  }

  protected String i()
  {
    return getLocalString("selectSheetFunction.text");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.FunctionSheetToken
 * JD-Core Version:    0.6.0
 */