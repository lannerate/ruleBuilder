package com.flagleader.repository.rlm.editen;

public abstract interface ITextEditen extends IEditen
{
  public abstract String getText();

  public abstract void setText(String paramString);

  public abstract String getNote();

  public abstract boolean checkValue(String paramString);

  public abstract String getColorType();

  public abstract boolean hasHint();

  public abstract String getHint();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.editen.ITextEditen
 * JD-Core Version:    0.6.0
 */