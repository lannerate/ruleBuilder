package com.flagleader.repository.tree;

public abstract interface ao
{
  public abstract IRuleRepository getRepository();

  public abstract IRulePackage getMainPackage();

  public abstract Envionment getEnvionment();

  public abstract String getRuleSetName();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.ao
 * JD-Core Version:    0.6.0
 */