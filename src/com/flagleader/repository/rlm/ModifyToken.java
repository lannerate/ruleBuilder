package com.flagleader.repository.rlm;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.k;
import com.flagleader.repository.rlm.editen.IModifierEditen;
import com.flagleader.util.exception.UnsupportOperationException;

public abstract class ModifyToken extends AbstractRuleObject
  implements IModifierEditen
{
  private String note = "";
  private transient k event = null;

  public ModifyToken()
  {
  }

  public ModifyToken(String paramString, k paramk)
  {
    this.note = paramString;
    this.event = paramk;
  }

  public ModifyToken(ModifyToken paramModifyToken)
  {
    super(paramModifyToken);
    this.note = paramModifyToken.note;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitModifyToken(this);
  }

  public k getEvent()
  {
    return this.event;
  }

  public String getNote()
  {
    if ((this.note != null) && (this.note.length() > 0) && (this.note.charAt(0) == '&'))
      return getLocalString(this.note.substring(1) + ".edit", this.note.substring(1));
    return this.note;
  }

  public void setEvent(k paramk)
  {
    this.event = paramk;
  }

  public void setNote(String paramString)
  {
    this.note = paramString;
  }

  public void doAction()
  {
    if (this.event != null)
      this.event.a();
  }

  public IElement deepClone()
  {
    throw new UnsupportOperationException();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.ModifyToken
 * JD-Core Version:    0.6.0
 */