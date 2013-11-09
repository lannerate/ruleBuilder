package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.excel.IExcelObject;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.Envionment;
import java.util.Iterator;

public class MemberExcelToken extends MemberToken
  implements IStatementToken
{
  public MemberExcelToken(MemberExcelToken paramMemberExcelToken)
  {
    super(paramMemberExcelToken);
  }

  public MemberExcelToken()
  {
  }

  public MemberExcelToken(String paramString)
  {
    super(paramString);
  }

  public IElement deepClone()
  {
    return new MemberExcelToken(this);
  }

  protected Iterator e()
  {
    String str = getValueType();
    return getEnvionment().getAcceptElements(new c(this, str));
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
      else if (((localIBusinessObjectEditen instanceof IExcelObject)) && (str != null) && (str.length() > 0) && (!localIBusinessObjectEditen.getJavaType().l()) && (localIBusinessObjectEditen.getJavaType().d(str)))
        return true;
    }
    return false;
  }

  public String getName()
  {
    return "MemberExcelToken";
  }

  protected String i()
  {
    return getLocalString("selectExcelMember.text");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.MemberExcelToken
 * JD-Core Version:    0.6.0
 */