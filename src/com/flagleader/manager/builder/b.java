package com.flagleader.manager.builder;

import com.flagleader.manager.dialog.IDialogInfo;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.ITreeNode;
import java.sql.Connection;

public abstract interface b
{
  public static final int b = 0;
  public static final int c = 1;

  public abstract void showError(String paramString);

  public abstract void showSuccess(String paramString);

  public abstract void showInformation(String paramString1, String paramString2);

  public abstract void showWarning(String paramString);

  public abstract void showConfirm(String paramString, IAfterAction paramIAfterAction);

  public abstract void showQuestion(String paramString, IAfterAction paramIAfterAction);

  public abstract boolean showQuestion(String paramString);

  public abstract void showDialog(IDialogInfo paramIDialogInfo);

  public abstract void copy(IElement paramIElement);

  public abstract IElement paste();

  public abstract boolean isPlugInApp();

  public abstract boolean isWebEditor();

  public abstract Connection loginRuleServer();

  public abstract void gotoTreeNode(ITreeNode paramITreeNode);

  public abstract String loadNewClass(String paramString);

  public abstract String getUserServer();

  public abstract int getUserType();

  public abstract int getUserid();

  public abstract d getProjectTree();

  public abstract void showLogin(String paramString);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.builder.b
 * JD-Core Version:    0.6.0
 */