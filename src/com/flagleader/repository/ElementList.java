package com.flagleader.repository;

import java.util.ArrayList;
import java.util.List;

public class ElementList extends AbstractElement
{
  private ArrayList child = new ArrayList();
  private IElement element = null;

  public ElementList(ElementList paramElementList)
  {
    super(paramElementList);
    this.child = paramElementList.child;
    this.element = paramElementList.element;
  }

  public ElementList(String paramString)
  {
    setDisplayName(paramString);
  }

  public ElementList(IElement paramIElement)
  {
    setDisplayName(paramIElement.getDisplayName());
    this.element = paramIElement;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return null;
  }

  public IElement deepClone()
  {
    return new ElementList(this);
  }

  public String getName()
  {
    return "ElementList";
  }

  public void add(IElement paramIElement)
  {
    this.child.add(paramIElement);
  }

  public void add(int paramInt, IElement paramIElement)
  {
    this.child.add(paramInt, paramIElement);
  }

  public void addAll(List paramList)
  {
    this.child.addAll(paramList);
  }

  public IElement[] toArray()
  {
    IElement[] arrayOfIElement = new IElement[this.child.size()];
    for (int i = 0; i < arrayOfIElement.length; i++)
      arrayOfIElement[i] = ((IElement)this.child.get(i));
    return arrayOfIElement;
  }

  public IElement get(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.child.size()))
      return (IElement)this.child.get(paramInt);
    return null;
  }

  public void remove(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.child.size()))
      this.child.remove(paramInt);
  }

  public void remove(IElement paramIElement)
  {
    this.child.remove(paramIElement);
  }

  public IElement getElement()
  {
    return this.element;
  }

  public void setElement(IElement paramIElement)
  {
    this.element = paramIElement;
  }

  public int size()
  {
    return this.child.size();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.ElementList
 * JD-Core Version:    0.6.0
 */