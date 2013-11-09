package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.k;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.rom.IBusinessObject;

public class ValueToken$TypeJudgeToken extends JudgeToken
  implements ISelectorEditen
{
  public ValueToken$TypeJudgeToken(ValueToken paramValueToken)
  {
  }

  public ValueToken$TypeJudgeToken(ValueToken paramValueToken, TypeJudgeToken paramTypeJudgeToken)
  {
    super(paramTypeJudgeToken);
  }

  public String getName()
  {
    return "TypeJudgeToken";
  }

  public int getCount()
  {
    return ValueToken.access$2().length + 1;
  }

  public boolean acceptType(g paramg)
  {
    return true;
  }

  protected k b(int paramInt)
  {
    return this.this$0.a(paramInt);
  }

  protected String a(int paramInt)
  {
    return ValueToken.access$2()[paramInt];
  }

  public String getDisplayName()
  {
    if (this.this$0.getValueElement() != null)
      return ":";
    return getLocalString("selectAction.edit");
  }

  public String getNote()
  {
    if (ValueToken.access$3(this.this$0).length() > 0)
      return ValueToken.access$3(this.this$0);
    return super.getNote();
  }

  public boolean isLocked()
  {
    return this.this$0.isLocked();
  }

  public String toString()
  {
    return "";
  }

  public String getColorType()
  {
    return "select";
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    if (((paramObject instanceof ConstantEnum)) || ((paramObject instanceof IBusinessObject)) || ((paramObject instanceof String)) || ((paramObject instanceof ValueToken)))
      return true;
    return super.acceptBusinessObject(paramObject);
  }

  public boolean pasteBusinessObject(Object paramObject)
  {
    return this.this$0.pasteBusinessObject(paramObject);
  }

  public String getUuid()
  {
    return this.this$0.getUuid();
  }

  public IElement getBusinessObject()
  {
    return this.this$0;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.ValueToken.TypeJudgeToken
 * JD-Core Version:    0.6.0
 */