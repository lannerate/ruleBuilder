package com.flagleader.repository.tree;

import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IFunctionObject;
import java.util.List;

public abstract interface IRulePackage extends IOpenNode, IRuleClass, ITreeNode
{
  public static final int AUTODEPLOYSERVER = 5;

  public abstract IRuleProject getProject();

  public abstract Envionment getEnvionment();

  public abstract IPackageElement findRuleHistory(String paramString1, String paramString2);

  public abstract boolean canFindHistory();

  public abstract boolean isDeveloper();

  public abstract void changeElementType(IBusinessObject paramIBusinessObject);

  public abstract void changeParamType(IFunctionObject paramIFunctionObject);

  public abstract String[] getClassPaths();

  public abstract String getClassPath();

  public abstract String getCompilePath();

  public abstract String getExportDir();

  public abstract boolean isPlugin();

  public abstract boolean isIgniorString();

  public abstract int getDatenulltype();

  public abstract String getExeRulePackageName();

  public abstract String getVersion();

  public abstract String getMainVersion();

  public abstract String getIdAndVersion();

  public abstract String getCurrentUser();

  public abstract PackageHistory getHistory();

  public abstract boolean needRecompile();

  public abstract List getAllElementSelect(IBusinessObject paramIBusinessObject);

  public abstract void save();

  public abstract IRuleRepository getRepository();

  public abstract String getFilePathName();

  public abstract void setError(List paramList);

  public abstract boolean needCheck();

  public abstract boolean hasError();

  public abstract List getErrorList();

  public abstract String compile(boolean paramBoolean);

  public abstract void setFilePathName(String paramString);

  public abstract void setCompilePath(String paramString);

  public abstract void setClassPaths(String[] paramArrayOfString);

  public abstract String getSavedText();

  public abstract void setDirPath(String paramString);

  public abstract String getExportDirPath();

  public abstract boolean canDeleteFile();

  public abstract int getVmlFlowType();

  public abstract String getTemplateType();

  public abstract int getLogType();

  public abstract int getRuletypeid();

  public abstract boolean isNeedSave();

  public abstract boolean needCheckSubRule();

  public abstract int getChecktype();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.IRulePackage
 * JD-Core Version:    0.6.0
 */