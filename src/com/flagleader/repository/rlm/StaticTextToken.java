package com.flagleader.repository.rlm;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rlm.editen.IStaticEditen;

public class StaticTextToken extends AbstractRuleObject
  implements IStaticEditen
{
  private int size = 0;
  private String colorType = "default";

  public StaticTextToken()
  {
  }

  public StaticTextToken(int paramInt)
  {
    this.size = paramInt;
  }

  public StaticTextToken(StaticTextToken paramStaticTextToken)
  {
    super(paramStaticTextToken);
    this.size = paramStaticTextToken.size;
  }

  public StaticTextToken(String paramString1, String paramString2)
  {
    setDisplayName(paramString1);
    this.colorType = paramString2;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitStaticText(this);
  }

  public IElement deepClone()
  {
    return new StaticTextToken(this);
  }

  public String getName()
  {
    return "StaticTextToken";
  }

  public int getSize()
  {
    return this.size;
  }

  public void setSize(int paramInt)
  {
    this.size = paramInt;
  }

  public String getColorType()
  {
    return this.colorType;
  }

  public void setColorType(String paramString)
  {
    this.colorType = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.StaticTextToken
 * JD-Core Version:    0.6.0
 */