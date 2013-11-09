package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.tree.Envionment;
import java.util.Iterator;

public class MethodToken extends MemberToken
  implements IStatementToken
{
  public static final String DISPLAYNAME = getLocalString("selectMethod.text");

  public MethodToken()
  {
  }

  public MethodToken(String paramString)
  {
    super(paramString);
  }

  public MethodToken(MethodToken paramMethodToken)
  {
    super(paramMethodToken);
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitMethodToken(this);
  }

  protected Iterator e()
  {
    return getEnvionment().getAllMethod(getValueType(), getWhileSheets() != null);
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    String str = getValueType();
    if ((paramObject instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if (((localIBusinessObjectEditen instanceof IFunctionObject)) && ((str == null) || (str.length() == 0) || (localIBusinessObjectEditen.getJavaType().d(str))))
        return true;
    }
    return false;
  }

  public String getName()
  {
    return "MethodToken";
  }

  public IElement deepClone()
  {
    return new MethodToken(this);
  }

  protected String i()
  {
    return DISPLAYNAME;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.MethodToken
 * JD-Core Version:    0.6.0
 */