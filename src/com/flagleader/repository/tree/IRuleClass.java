package com.flagleader.repository.tree;

public abstract interface IRuleClass extends IPackageElement
{
  public abstract String getClassName();

  public abstract String getPackageName();

  public abstract String getClassPath();

  public abstract String getExeRulePackageName();

  public abstract String getFileName();

  public abstract boolean needRecompile();

  public abstract String getCompilePath();

  public abstract IRulePackage getCompilePackage();

  public abstract String getVisitExeName();

  public abstract void setSupportVisit(boolean paramBoolean);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.IRuleClass
 * JD-Core Version:    0.6.0
 */