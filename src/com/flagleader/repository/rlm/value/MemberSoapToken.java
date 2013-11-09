package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.Envionment;
import java.util.Iterator;

public class MemberSoapToken extends MemberToken
  implements IStatementToken
{
  public MemberSoapToken(MemberSoapToken paramMemberSoapToken)
  {
    super(paramMemberSoapToken);
  }

  public MemberSoapToken()
  {
  }

  public MemberSoapToken(String paramString)
  {
    super(paramString);
  }

  public IElement deepClone()
  {
    return new MemberSoapToken(this);
  }

  protected Iterator e()
  {
    String str = getValueType();
    return getEnvionment().getAcceptElements(new i(this, str));
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    String str = getValueType();
    if ((paramObject instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if ((localIBusinessObjectEditen instanceof IVariableObject))
      {
        if ((str == null) || (str.length() == 0) || (localIBusinessObjectEditen.getJavaType().d(str)))
          return true;
      }
      else if ((localIBusinessObjectEditen instanceof IFunctionObject))
      {
        if (((str != null) && (str.length() != 0)) || ((!localIBusinessObjectEditen.getJavaType().l()) || (localIBusinessObjectEditen.getJavaType().d(str))))
          return true;
      }
      else if (((localIBusinessObjectEditen instanceof SoapService)) && (str != null) && (str.length() > 0) && (!localIBusinessObjectEditen.getJavaType().l()) && (localIBusinessObjectEditen.getJavaType().d(str)))
        return true;
    }
    return false;
  }

  public String getName()
  {
    return "MemberSoapToken";
  }

  protected String i()
  {
    return getLocalString("selectSoapMember.text");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.MemberSoapToken
 * JD-Core Version:    0.6.0
 */