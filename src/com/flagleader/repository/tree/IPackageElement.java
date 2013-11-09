package com.flagleader.repository.tree;

public abstract interface IPackageElement extends ITreeNode
{
  public static final int ALLCANEDIT = 0;
  public static final int EDITORCANNOTEDIT = 1;
  public static final int EDITCANNOTVIEW = 2;
  public static final int DEVELOPCANNOTEDIT = 3;

  public abstract IRulePackage getMainPackage();

  public abstract Envionment getEnvionment();

  public abstract boolean isDevelopModel();

  public abstract boolean canVmlShow();

  public abstract void setVml(int paramInt);

  public abstract int getVml();

  public abstract String getText();

  public abstract IPackageElement findTreeNode(String paramString);

  public abstract void setNeedSave();

  public abstract long getReloadTime();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.IPackageElement
 * JD-Core Version:    0.6.0
 */