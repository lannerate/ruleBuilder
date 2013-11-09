package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.AbstractBOToken;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.tree.Envionment;
import java.util.Iterator;

public class ConstantSelectToken extends AbstractBOToken
  implements ISelectorEditen, IValueToken
{
  public static final String DISPLAYNAME = getLocalString("selectEnumMember.text");

  public ConstantSelectToken(ConstantSelectToken paramConstantSelectToken)
  {
    super(paramConstantSelectToken);
  }

  public ConstantSelectToken()
  {
  }

  public ConstantSelectToken(String paramString)
  {
    super(paramString);
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitConstantSelectToken(this);
  }

  public IElement deepClone()
  {
    return new ConstantSelectToken(this);
  }

  protected Iterator e()
  {
    return getEnvionment().getEnums(getValueType());
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    String str = getValueType();
    return ((paramObject instanceof ConstantEnum)) && ((str == null) || (str.length() == 0) || (((ConstantEnum)paramObject).getJavaType().b(str)));
  }

  public ConstantEnum getConstantMember()
  {
    IElement localIElement = getMemberElement();
    if ((localIElement instanceof ConstantEnum))
      return (ConstantEnum)getMemberElement();
    return null;
  }

  public String getName()
  {
    return "ConstantSelectToken";
  }

  public String getDisplayName()
  {
    String str = super.getDisplayName();
    if ((str != null) && (str.length() > 0))
      return str;
    return DISPLAYNAME;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.ConstantSelectToken
 * JD-Core Version:    0.6.0
 */