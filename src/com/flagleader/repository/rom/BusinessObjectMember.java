package com.flagleader.repository.rom;

import com.flagleader.a.M;
import com.flagleader.a.P;
import com.flagleader.a.ak;
import com.flagleader.a.y;
import com.flagleader.util.exception.UnsupportOperationException;

public abstract class BusinessObjectMember extends AbstractBOEditen
  implements IMemberObject
{
  private transient M member = null;
  private String memberName = "";
  private String shortMemberName = "";

  public BusinessObjectMember(BusinessObjectMember paramBusinessObjectMember)
  {
    super(paramBusinessObjectMember);
    this.memberName = paramBusinessObjectMember.memberName;
    this.shortMemberName = paramBusinessObjectMember.shortMemberName;
    this.member = paramBusinessObjectMember.member;
  }

  public BusinessObjectMember()
  {
    setVisible(false);
  }

  public BusinessObjectMember(String paramString)
  {
    setDisplayName(sortedDisplayName(paramString));
    setVisible(false);
  }

  public String getMemberName()
  {
    return this.memberName;
  }

  public void setMember(M paramM, int paramInt)
  {
    this.member = paramM;
    setMemberName(paramM.I());
    setShortMemberName(paramM.N());
    if (isMethod())
      changeValueType(((P)this.member).n().K());
    else if (isAttribute())
      changeValueType(((y)this.member).e().K());
    g();
  }

  public boolean isMethod()
  {
    return this instanceof BusinessObjectMethod;
  }

  public boolean isAttribute()
  {
    return this instanceof BusinessObjectAttribute;
  }

  public boolean isFinal()
  {
    if ((getParent() != null) && (f() == null))
      ((BusinessObjectClass)getParent()).update();
    return f().i();
  }

  public boolean isStatic()
  {
    if ((getParent() != null) && (f() == null))
      ((BusinessObjectClass)getParent()).update();
    return f().m();
  }

  private void g()
  {
    if (this.member == null)
      return;
    this.member.a(isVisible());
  }

  public void setDisplayName(String paramString)
  {
    if (paramString != null)
      super.setDisplayName(paramString);
  }

  public void setVisible(boolean paramBoolean)
  {
    super.setVisible(paramBoolean);
    g();
  }

  public void setMemberName(String paramString)
  {
    this.memberName = paramString;
  }

  protected M f()
  {
    return this.member;
  }

  public String getMemberClassName()
  {
    if (getClassObject() != null)
      return getClassObject().getValueType();
    return getMemberName().substring(0, getMemberName().indexOf("("));
  }

  public String getUniqueName()
  {
    if (getParent() != null)
    {
      if ((getParent() instanceof BusinessObjectClass))
        return ((BusinessObjectClass)getParent()).getClassName() + "." + getValueName();
      if ((getParent() instanceof IBusinessObject))
        return ((IBusinessObject)getParent()).getVarValue() + "." + getValueName();
      return getValueName();
    }
    return getValueName();
  }

  public String getShortMemberName()
  {
    return this.shortMemberName;
  }

  public void setShortMemberName(String paramString)
  {
    this.shortMemberName = paramString;
  }

  public IBusinessObject getClassObject()
  {
    if (getParent() != null)
      return (IBusinessObject)getParent();
    return null;
  }

  public String getValueName()
  {
    return getMemberName();
  }

  public void setValueName(String paramString)
  {
    throw new UnsupportOperationException();
  }

  public boolean canDelete()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.BusinessObjectMember
 * JD-Core Version:    0.6.0
 */