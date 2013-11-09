package com.flagleader.repository;

import com.flagleader.repository.collections.Acceptor;
import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.collections.h;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public abstract interface IElement extends h, f, g, Serializable
{
  public abstract String getUuid();

  public abstract String getShortId();

  public abstract void setUuid(String paramString);

  public abstract String getName();

  public abstract String getDisplayName();

  public abstract String getShowDisplayName();

  public abstract void setDisplayName(String paramString);

  public abstract Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor);

  public abstract IElement getParent();

  public abstract void setParent(IElement paramIElement);

  public abstract IElement getRootParent();

  public abstract void clearAllChildren();

  public abstract Iterator getChildrenIterator();

  public abstract List getChildrenList();

  public abstract Iterator getAcceptChildren(Acceptor paramAcceptor);

  public abstract Iterator getAcceptElements(ChildAcceptor paramChildAcceptor);

  public abstract void addChildElement(IElement paramIElement);

  public abstract void addChildElement(IElement paramIElement, int paramInt);

  public abstract void removeChildElement(IElement paramIElement);

  public abstract int getChildrenCount();

  public abstract boolean hasChildren();

  public abstract void dispose();

  public abstract IElement deepClone();

  public abstract int getElementPos(IElement paramIElement);

  public abstract void moveElement(int paramInt1, int paramInt2);

  public abstract boolean isLocked();

  public abstract IElement findNode(String paramString);

  public abstract String getEditUuid();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.IElement
 * JD-Core Version:    0.6.0
 */