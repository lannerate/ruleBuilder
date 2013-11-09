package com.flagleader.repository;

import com.flagleader.repository.collections.Acceptor;
import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.collections.g;
import com.flagleader.repository.d.H;
import com.flagleader.repository.d.u;
import com.flagleader.repository.lang.d;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.util.TempID;
import com.flagleader.util.UUID;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractElement
  implements IElement, Cloneable
{
  private transient IElement parent = null;
  private String displayName = "";
  private String uuid = null;
  private List childrenElement = null;
  private transient String editUuid = null;

  public AbstractElement()
  {
    this.displayName = "";
  }

  public AbstractElement(String paramString)
  {
    this.displayName = paramString;
  }

  public AbstractElement(AbstractElement paramAbstractElement)
  {
    this.displayName = paramAbstractElement.displayName;
    for (int i = 0; i < paramAbstractElement.getChildrenCount(); i++)
      addChildElement(((Cloneable)paramAbstractElement.a().get(i)).deepClone());
  }

  public String getDisplayName()
  {
    return this.displayName;
  }

  public void setDisplayName(String paramString)
  {
    if ((paramString != null) && (!this.displayName.equals(paramString)))
      this.displayName = paramString.trim();
  }

  public IElement getRootParent()
  {
    if (getParent() != null)
      return getParent().getRootParent();
    return this;
  }

  public IElement getParent()
  {
    return this.parent;
  }

  public void setParent(IElement paramIElement)
  {
    this.parent = paramIElement;
  }

  public String getUuid()
  {
    if ((this.uuid == null) || (this.uuid.length() == 0))
      this.uuid = UUID.shortUUID();
    return this.uuid;
  }

  public void setUuid(String paramString)
  {
    this.uuid = paramString;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null)
      return false;
    if (paramObject == this)
      return true;
    return super.equals(paramObject);
  }

  protected List a()
  {
    if (this.childrenElement == null)
      this.childrenElement = new ArrayList();
    return this.childrenElement;
  }

  public List getChildrenList()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    if (this.childrenElement != null)
      localArrayList.addAll(this.childrenElement);
    return localArrayList;
  }

  public int indexOfElement(IElement paramIElement)
  {
    if (this.childrenElement != null)
      return this.childrenElement.indexOf(paramIElement);
    return -1;
  }

  public Iterator getChildrenIterator()
  {
    if (this.childrenElement == null)
      return g.a();
    return this.childrenElement.iterator();
  }

  public int getChildrenCount()
  {
    if (this.childrenElement == null)
      return 0;
    return this.childrenElement.size();
  }

  public boolean hasChildren()
  {
    return getChildrenCount() > 0;
  }

  public void addChildElement(IElement paramIElement)
  {
    addChildElement(paramIElement, getChildrenCount());
  }

  public int getElementPos(IElement paramIElement)
  {
    if (getChildrenCount() == 0)
      return 0;
    if (paramIElement == null)
      return 0;
    return this.childrenElement.indexOf(paramIElement);
  }

  public void moveElement(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 < getChildrenCount()) && (paramInt2 >= 0) && (paramInt2 < getChildrenCount()) && (paramInt1 != paramInt2))
    {
      Object localObject = this.childrenElement.remove(paramInt1);
      this.childrenElement.add(paramInt2, localObject);
    }
  }

  public void addChildElement(IElement paramIElement, int paramInt)
  {
    if (b())
      return;
    if (paramIElement == null)
      return;
    if (paramInt < 0)
      paramInt = 0;
    if (this.childrenElement == null)
      this.childrenElement = new ArrayList();
    if (paramInt > getChildrenCount())
      paramInt = getChildrenCount();
    paramIElement.setParent(this);
    if (a(paramIElement))
      this.childrenElement.add(paramInt, paramIElement);
    else
      throw new H(getName() + ":" + getUuid() + ";" + paramIElement.getName() + ":" + paramIElement.getUuid());
  }

  protected boolean b()
  {
    return false;
  }

  protected boolean c()
  {
    return false;
  }

  public void removeChildElement(IElement paramIElement)
  {
    if (this.childrenElement != null)
      this.childrenElement.remove(paramIElement);
  }

  public void clearAllChildren()
  {
    if (this.childrenElement != null)
      this.childrenElement.clear();
  }

  public void dispose()
  {
    if (this.childrenElement != null)
    {
      for (int i = 0; i < this.childrenElement.size(); i++)
        ((Cloneable)this.childrenElement.get(i)).dispose();
      clearAllChildren();
    }
    if (getParent() != null)
      getParent().removeChildElement(this);
    this.parent = null;
  }

  protected boolean a(IElement paramIElement)
  {
    return true;
  }

  public int hashCode()
  {
    return 37 * getUuid().hashCode() + 17;
  }

  public String getChildDefaultName(String paramString)
  {
    HashMap localHashMap = new HashMap();
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      localHashMap.put(((Cloneable)localList.get(i)).getDisplayName(), localList.get(i));
    if (localHashMap.get(paramString) == null)
      return paramString;
    for (i = 1; i < localList.size(); i++)
      if (localHashMap.get(paramString + i) == null)
        return paramString + i;
    return paramString + localList.size();
  }

  public static String getLocalString(String paramString1, String paramString2)
  {
    return u.a(paramString1, paramString2);
  }

  public static String getLocalString(String paramString)
  {
    return u.a(paramString);
  }

  public static String format(String paramString, Object[] paramArrayOfObject)
  {
    return u.a(paramString, paramArrayOfObject);
  }

  protected Object clone()
  {
    return deepClone();
  }

  public String toString()
  {
    return getDisplayName();
  }

  public boolean isLocked()
  {
    if (getParent() != null)
      return getParent().isLocked();
    return false;
  }

  public List copyAllChildren()
  {
    List localList = a();
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    for (int i = 0; i < localList.size(); i++)
    {
      if ((!(localList.get(i) instanceof Cloneable)) || ((localList.get(i) instanceof ITreeNode)))
        continue;
      localArrayList.add(((Cloneable)localList.get(i)).deepClone());
    }
    return localArrayList;
  }

  public void replaceAllChildren(List paramList)
  {
    List localList = a();
    for (int i = localList.size() - 1; i >= 0; i--)
    {
      if ((!(localList.get(i) instanceof Cloneable)) || ((localList.get(i) instanceof ITreeNode)))
        continue;
      removeElement(i);
    }
    for (i = 0; i < paramList.size(); i++)
      addChildElement((Cloneable)paramList.get(i));
  }

  public IElement findNode(String paramString)
  {
    for (int i = 0; i < getChildrenCount(); i++)
    {
      IElement localIElement1 = (Cloneable)a().get(i);
      if (localIElement1.getUuid().equals(paramString))
        return localIElement1;
      IElement localIElement2 = localIElement1.findNode(paramString);
      if (localIElement2 != null)
        return localIElement2;
    }
    return null;
  }

  public IElement getElement(int paramInt)
  {
    if (this.childrenElement == null)
      return null;
    return (Cloneable)this.childrenElement.get(paramInt);
  }

  public void removeElement(int paramInt)
  {
    if (this.childrenElement != null)
      this.childrenElement.remove(paramInt);
  }

  public String getEditUuid()
  {
    if (this.editUuid == null)
      this.editUuid = TempID.newShortTempID();
    return this.editUuid;
  }

  public Iterator getAcceptChildren(Acceptor paramAcceptor)
  {
    return new com.flagleader.repository.collections.a(getChildrenIterator(), paramAcceptor);
  }

  public Iterator getAcceptElements(ChildAcceptor paramChildAcceptor)
  {
    return new com.flagleader.repository.collections.c(getChildrenIterator(), paramChildAcceptor);
  }

  public Iterator getTypeChildren(Class paramClass)
  {
    return new com.flagleader.repository.collections.a(getChildrenIterator(), new a(this, paramClass));
  }

  public Iterator getTypeSuperChildren(Class paramClass)
  {
    return new com.flagleader.repository.collections.a(getChildrenIterator(), new b(this, paramClass));
  }

  public List getTypeSuperChildrenList(Class paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!paramClass.isAssignableFrom(localObject.getClass()))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public int getTypeChildrenCount(Class paramClass)
  {
    int i = 0;
    if (this.childrenElement != null)
      for (int j = 0; j < this.childrenElement.size(); j++)
      {
        if (!this.childrenElement.get(j).getClass().equals(paramClass))
          continue;
        i++;
      }
    return i;
  }

  public int getTypeSuperChildrenCount(Class paramClass)
  {
    int i = 0;
    if (this.childrenElement != null)
      for (int j = 0; j < this.childrenElement.size(); j++)
      {
        if (!paramClass.isAssignableFrom(this.childrenElement.get(j).getClass()))
          continue;
        i++;
      }
    return i;
  }

  public h getTypeManager()
  {
    return m.a().g();
  }

  public d getMethodManager()
  {
    return m.a().h();
  }

  public com.flagleader.repository.lang.c getLanguageWriter()
  {
    return m.a().i();
  }

  public String getShowDisplayName()
  {
    return getDisplayName();
  }

  public String getShortId()
  {
    if (getParent() != null)
      return getParent().getShortId() + "." + getParent().getElementPos(this);
    return "1";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.AbstractElement
 * JD-Core Version:    0.6.0
 */