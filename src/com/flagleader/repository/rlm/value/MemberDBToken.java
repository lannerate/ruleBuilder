package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.ISubVariable;
import com.flagleader.repository.tree.Envionment;
import java.util.Iterator;

public class MemberDBToken extends MemberToken
  implements IStatementToken
{
  public MemberDBToken(MemberDBToken paramMemberDBToken)
  {
    super(paramMemberDBToken);
  }

  public MemberDBToken()
  {
  }

  public MemberDBToken(String paramString)
  {
    super(paramString);
  }

  public IElement deepClone()
  {
    return new MemberDBToken(this);
  }

  protected Iterator e()
  {
    String str = getValueType();
    return getEnvionment().getAcceptElements(new b(this, str));
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    String str = getValueType();
    if ((paramObject instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if (((localIBusinessObjectEditen instanceof IFunctionObject)) || ((localIBusinessObjectEditen instanceof ISubVariable)))
      {
        if (((str != null) && (str.length() != 0)) || ((!localIBusinessObjectEditen.getJavaType().l()) || (localIBusinessObjectEditen.getJavaType().d(str))))
          return true;
      }
      else if (((localIBusinessObjectEditen instanceof ISelectObject)) && (str != null) && (str.length() > 0) && (!localIBusinessObjectEditen.getJavaType().l()) && (localIBusinessObjectEditen.getJavaType().d(str)))
        return true;
    }
    return false;
  }

  public String getName()
  {
    return "MemberDBToken";
  }

  protected String i()
  {
    return getLocalString("selectDBMember.text");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.MemberDBToken
 * JD-Core Version:    0.6.0
 */