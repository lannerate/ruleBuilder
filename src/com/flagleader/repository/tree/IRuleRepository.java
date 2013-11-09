package com.flagleader.repository.tree;

import com.flagleader.repository.d.a;
import com.flagleader.repository.h;
import java.util.Iterator;
import java.util.List;

public abstract interface IRuleRepository extends IOpenNode, ITreeNode
{
  public abstract void autoSave();

  public abstract void clearAutoSave();

  public abstract List getAutoSavedPack();

  public abstract boolean recoverAutoSavePack(List paramList);

  public abstract void clearBackup(List paramList);

  public abstract void backup(List paramList);

  public abstract List getClosedNode();

  public abstract String getLocalUser();

  public abstract String getExportExeRulePath();

  public abstract h getLogger();

  public abstract IRulePackage exitsPackage(String paramString);

  public abstract IRulePackage exitsDBPackage(String paramString);

  public abstract void addDBPackage(IRulePackage paramIRulePackage, String paramString1, String paramString2);

  public abstract void addProjPackage(IRulePackage paramIRulePackage, String paramString1, String paramString2);

  public abstract RuleDBProject getDBProject(String paramString);

  public abstract void addDBProject(String paramString);

  public abstract Iterator getRulePackages();

  public abstract void setAutoCompile(boolean paramBoolean);

  public abstract void setExportPagePath(String paramString);

  public abstract void setExportExeRulePath(String paramString);

  public abstract void setNeedSave(boolean paramBoolean);

  public abstract void setRuleServer(an paraman);

  public abstract int getUserType();

  public abstract an getRuleServer();

  public abstract a getBomClassLoader();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.IRuleRepository
 * JD-Core Version:    0.6.0
 */