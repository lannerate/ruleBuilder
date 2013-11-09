package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementEditor;
import com.flagleader.repository.IElementViewer;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public abstract interface ITreeNode extends IElement, am
{
  public abstract Iterator getChildNodes();

  public abstract boolean hasChildNodes();

  public abstract Iterator getAcceptNodes();

  public abstract ITreeNode createChildNode(String paramString);

  public abstract List getPropertiesList();

  public abstract String getPropertyValue(String paramString);

  public abstract void setPropertyValue(String paramString1, String paramString2);

  public abstract boolean acceptNode(ITreeNode paramITreeNode);

  public abstract boolean acceptNode(String paramString);

  public abstract boolean canCopy();

  public abstract boolean canCut();

  public abstract boolean canDelete();

  public abstract boolean canRename();

  public abstract ITreeNode copy();

  public abstract ITreeNode cut();

  public abstract boolean paste(IElement paramIElement);

  public abstract void setElementEditor(IElementEditor paramIElementEditor);

  public abstract void updateTree();

  public abstract void updateText();

  public abstract void addViewer(IElementViewer paramIElementViewer);

  public abstract void removeViewer(IElementViewer paramIElementViewer);

  public abstract void updateViewer();

  public abstract void disposeAllViewer();

  public abstract void dispose();

  public abstract void disposeAndUpdate();

  public abstract void disposeAllChildren();

  public abstract boolean isModified();

  public abstract void changeDisplayName(String paramString);

  public abstract void setModified(boolean paramBoolean);

  public abstract boolean isVisible();

  public abstract String getDocument();

  public abstract void setDocument(String paramString);

  public abstract long getModifyTime();

  public abstract void setModifyTime(long paramLong);

  public abstract String getInfo();

  public abstract IRuleProject getProject();

  public abstract void save();

  public abstract String getSrcPath();

  public abstract void setFileLastTime(long paramLong);

  public abstract boolean needReload();

  public abstract void reloadFromFile(File paramFile);

  public abstract long getMaxModifyTime();

  public abstract void selfsave(boolean paramBoolean);

  public abstract String getLastModifyTime();

  public abstract boolean isNeedSave();

  public abstract void replacePos(IElement paramIElement1, IElement paramIElement2);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.ITreeNode
 * JD-Core Version:    0.6.0
 */