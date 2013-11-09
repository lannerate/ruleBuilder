package com.flagleader.repository.tree;

public abstract interface IRuleProject extends IOpenNode, IRuleGroup, ITreeNode
{
  public abstract void save(RulePackage paramRulePackage, boolean paramBoolean);

  public abstract void save(Envionment paramEnvionment, boolean paramBoolean);

  public abstract void save(TestCaseLib paramTestCaseLib, boolean paramBoolean);

  public abstract void selfSave();

  public abstract void setNeedSave(boolean paramBoolean);

  public abstract String getBakDir();

  public abstract String getDataDir();

  public abstract String getSrcDir();

  public abstract String getTestDir();

  public abstract RulePackage exitsPackage(String paramString);

  public abstract boolean canChangePackName(IRulePackage paramIRulePackage);

  public abstract IRuleRepository getRepository();

  public abstract void save();

  public abstract void close();

  public abstract String getFilePath();

  public abstract void setFilePath(String paramString);

  public abstract Envionment getEnvionment();

  public abstract void clearAutoSave(RulePackage paramRulePackage);

  public abstract boolean exitsSamePackage(String paramString);

  public abstract boolean isMultiFileSave();

  public abstract String getProjver();

  public abstract void setProjver(String paramString);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.IRuleProject
 * JD-Core Version:    0.6.0
 */