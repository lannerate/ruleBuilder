package com.flagleader.repository.tree;

import com.flagleader.engine.Property;
import com.flagleader.repository.AbstractElement;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementEditor;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.e.m;
import com.flagleader.repository.e.s;
import com.flagleader.repository.e.t;
import com.flagleader.repository.o;
import com.flagleader.util.TempID;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections.IteratorUtils;

public abstract class AbstractTreeNode extends AbstractElement
  implements ITreeNode
{
  protected transient IElementEditor c = null;
  protected transient boolean d = false;
  protected transient boolean e = false;
  private transient List viewer = null;
  private String document = "";
  protected long f = System.currentTimeMillis();
  private String modifyUser = "";
  private int vml = 0;
  private long fileLastTime = 0L;
  private transient o undoable = null;
  private ArrayList advanceProperties = null;

  public AbstractTreeNode()
  {
  }

  public AbstractTreeNode(AbstractTreeNode paramAbstractTreeNode)
  {
    super(paramAbstractTreeNode);
    this.document = paramAbstractTreeNode.document;
    for (int i = 0; i < paramAbstractTreeNode.getPropertiesList().size(); i++)
      getPropertiesList().add(new AdvancedProperty((AdvancedProperty)paramAbstractTreeNode.getPropertiesList().get(i)));
  }

  public AbstractTreeNode(String paramString)
  {
    setDisplayName(paramString);
  }

  public boolean acceptNode(ITreeNode paramITreeNode)
  {
    return false;
  }

  public boolean acceptNode(String paramString)
  {
    return false;
  }

  public boolean canCopy()
  {
    return (this instanceof ITreeNode);
  }

  public boolean canCut()
  {
    return true;
  }

  public boolean canDelete()
  {
    return true;
  }

  public boolean canRename()
  {
    return true;
  }

  public ITreeNode copy()
  {
    if ((this instanceof ITreeNode))
      return (ITreeNode)deepClone();
    return null;
  }

  public ITreeNode cut()
  {
    ITreeNode localITreeNode = (ITreeNode)deepClone();
    disposeAndUpdate();
    return localITreeNode;
  }

  public ITreeNode createChildNode(String paramString)
  {
    return null;
  }

  public void changeDisplayName(String paramString)
  {
    setDisplayName(paramString);
    setModified(true);
    if ((getParent() != null) && ((getParent() instanceof ITreeNode)))
      ((ITreeNode)getParent()).setModified(true);
  }

  public void dispose()
  {
    disposeAllViewer();
    setElementEditor(null);
    super.dispose();
  }

  public void disposeAndUpdate()
  {
    ITreeNode localITreeNode = null;
    if ((getParent() != null) && ((getParent() instanceof ITreeNode)))
      localITreeNode = (ITreeNode)getParent();
    dispose();
    if (localITreeNode != null)
    {
      localITreeNode.setModified(true);
      localITreeNode.updateTree();
    }
  }

  public void disposeAllChildren()
  {
    List localList = a();
    int i = 0;
    while (i < localList.size())
    {
      IElement localIElement = (IElement)localList.get(i);
      if ((localIElement instanceof ITreeNode))
      {
        ((ITreeNode)localIElement).disposeAllChildren();
        if (localIElement.getParent() == this)
        {
          ((ITreeNode)localIElement).dispose();
        }
        else
        {
          ((ITreeNode)localIElement).dispose();
          localList.remove(i);
        }
      }
      else
      {
        i++;
      }
    }
  }

  public Iterator getAcceptNodes()
  {
    return IteratorUtils.emptyIterator();
  }

  public Iterator getActions()
  {
    return IteratorUtils.emptyIterator();
  }

  public Iterator getChildNodes()
  {
    return getAcceptChildren(new h(this));
  }

  public IElementEditor getElementEditor()
  {
    return this.c;
  }

  public boolean hasChildNodes()
  {
    return getChildNodes().hasNext();
  }

  public boolean hasProperties()
  {
    return (this.advanceProperties != null) && (this.advanceProperties.size() > 0);
  }

  public boolean isModified()
  {
    if (this.d)
      return true;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof ITreeNode)) && (((ITreeNode)localObject).isModified()))
        return true;
    }
    return false;
  }

  public boolean isNeedSave()
  {
    return isModified();
  }

  public boolean paste(IElement paramIElement)
  {
    if ((paramIElement instanceof ElementContainer))
    {
      int i = 0;
      Iterator localIterator = ((ElementContainer)paramIElement).getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((!(localObject instanceof ITreeNode)) || (!acceptNode((ITreeNode)localObject)))
          continue;
        ((ITreeNode)localObject).setDisplayName(a((ITreeNode)localObject));
        addChildElement((ITreeNode)localObject);
        b((ITreeNode)localObject);
        i = 1;
      }
      if (i != 0)
        setModified(true);
      updateTree();
      return true;
    }
    if (((paramIElement instanceof ITreeNode)) && (acceptNode((ITreeNode)paramIElement)))
    {
      ((ITreeNode)paramIElement).setDisplayName(a((ITreeNode)paramIElement));
      addChildElement(paramIElement);
      b((ITreeNode)paramIElement);
      updateTree();
      setModified(true);
      return true;
    }
    return false;
  }

  protected String a(ITreeNode paramITreeNode)
  {
    if (!a(paramITreeNode.getDisplayName(), paramITreeNode.getClass()))
      return paramITreeNode.getDisplayName();
    for (int i = 1; i <= 100; i++)
      if (!a(paramITreeNode.getDisplayName() + i, paramITreeNode.getClass()))
        return paramITreeNode.getDisplayName() + i;
    return paramITreeNode.getDisplayName() + TempID.newShortTempID();
  }

  protected boolean a(String paramString, Class paramClass)
  {
    Iterator localIterator = getChildNodes();
    while (localIterator.hasNext())
    {
      ITreeNode localITreeNode = (ITreeNode)localIterator.next();
      if ((localITreeNode.getClass().equals(paramClass)) && (localITreeNode.getDisplayName().equals(paramString)))
        return true;
    }
    return false;
  }

  private void b(ITreeNode paramITreeNode)
  {
    paramITreeNode.setModified(true);
    Iterator localIterator = paramITreeNode.getChildNodes();
    while (localIterator.hasNext())
      b((ITreeNode)localIterator.next());
  }

  public void runAction(String paramString)
  {
  }

  public void setElementEditor(IElementEditor paramIElementEditor)
  {
    this.c = paramIElementEditor;
  }

  public void setModified(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Iterator localIterator = getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (!(localObject instanceof ITreeNode))
          continue;
        ((ITreeNode)localObject).setModified(paramBoolean);
      }
    }
    this.d = paramBoolean;
    if (paramBoolean)
    {
      setModifyTime(System.currentTimeMillis());
      if ((this instanceof AbstractPackageElement))
        setModifyUser(((AbstractPackageElement)this).getCurrentUser());
      if ((getParent() != null) && (((getParent() instanceof RuleRepository)) || ((getParent() instanceof IRuleGroup)) || ((getParent() instanceof IRuleProject))))
        ((ITreeNode)getParent()).setModified(true);
    }
    if ((paramBoolean) && ((this instanceof IRule)) && (!(this instanceof ExpressionRule)))
      updateColor();
  }

  public void addAdvanceProperty(AdvancedProperty paramAdvancedProperty)
  {
    a(paramAdvancedProperty.getKey());
    getPropertiesList().add(paramAdvancedProperty);
  }

  public List getPropertiesList()
  {
    if (this.advanceProperties == null)
      this.advanceProperties = new ArrayList(0);
    return this.advanceProperties;
  }

  public String getPropertyValue(String paramString)
  {
    for (int i = 0; i < getPropertiesList().size(); i++)
      if (((AdvancedProperty)getPropertiesList().get(i)).getKey().equals(paramString))
        return ((AdvancedProperty)getPropertiesList().get(i)).getProperty();
    return "";
  }

  public void setPropertyValue(String paramString1, String paramString2)
  {
    a(paramString1);
    getPropertiesList().add(new AdvancedProperty(paramString1, paramString2));
  }

  private void a(String paramString)
  {
    for (int i = 0; i < getPropertiesList().size(); i++)
    {
      if (!((AdvancedProperty)getPropertiesList().get(i)).getKey().equals(paramString))
        continue;
      getPropertiesList().remove(i);
    }
  }

  public void addViewer(IElementViewer paramIElementViewer)
  {
    d().add(paramIElementViewer);
  }

  public void updateTree()
  {
    if (this.c != null)
      this.c.update();
  }

  public void updateColor()
  {
    if (this.c != null)
      this.c.updateColor();
  }

  public void updateText()
  {
    if (this.c != null)
      this.c.updateText();
  }

  public void updateViewer()
  {
    for (int i = 0; i < d().size(); i++)
    {
      IElementViewer localIElementViewer = (IElementViewer)d().get(i);
      localIElementViewer.update();
    }
  }

  public void disposeAllViewer()
  {
    g();
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof ITreeNode))
        continue;
      ((ITreeNode)localList.get(i)).disposeAllViewer();
    }
  }

  protected void g()
  {
    for (int i = d().size() - 1; i >= 0; i--)
    {
      IElementViewer localIElementViewer = (IElementViewer)d().get(i);
      localIElementViewer.dispose();
      d().remove(localIElementViewer);
    }
  }

  public void removeViewer(IElementViewer paramIElementViewer)
  {
    d().remove(paramIElementViewer);
  }

  public String getDocument()
  {
    return this.document;
  }

  public void setDocument(String paramString)
  {
    this.document = paramString;
  }

  public long getMaxModifyTime()
  {
    long l1 = this.f;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof ITreeNode))
        continue;
      long l2 = ((ITreeNode)localObject).getMaxModifyTime();
      if (l2 <= l1)
        continue;
      l1 = l2;
    }
    return l1;
  }

  public long getModifyTime()
  {
    return this.f;
  }

  public void setModifyTime(long paramLong)
  {
    this.f = paramLong;
  }

  public String getLastModifyTime()
  {
    if (getModifyTime() > 0L)
      return Property.getInstance().formatDatetime(new Date(getModifyTime()));
    return "";
  }

  public String toString()
  {
    if (getParent() != null)
      return getParent().toString() + "-" + getDisplayName();
    return getDisplayName();
  }

  public String getInfo()
  {
    return getDisplayName();
  }

  public String getText()
  {
    return new m().b(this);
  }

  public String getModifyUser()
  {
    return this.modifyUser;
  }

  public void setModifyUser(String paramString)
  {
    this.modifyUser = paramString;
  }

  public void setChangedshint(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (paramBoolean)
      updateColor();
  }

  public boolean canVmlShow()
  {
    return this.vml == 0;
  }

  public int getVml()
  {
    return this.vml;
  }

  public void setVml(int paramInt)
  {
    this.vml = paramInt;
  }

  public boolean isVisible()
  {
    return false;
  }

  public List getAllNodes()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof AbstractTreeNode))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public int getPos()
  {
    if ((getParent() != null) && ((getParent() instanceof AbstractTreeNode)))
    {
      AbstractTreeNode localAbstractTreeNode = (AbstractTreeNode)getParent();
      return localAbstractTreeNode.getAllNodes().indexOf(this);
    }
    return 0;
  }

  public int getMaxPos()
  {
    if ((getParent() != null) && ((getParent() instanceof AbstractTreeNode)))
    {
      AbstractTreeNode localAbstractTreeNode = (AbstractTreeNode)getParent();
      return localAbstractTreeNode.getAllNodes().size();
    }
    return 0;
  }

  public int getMinPos()
  {
    if ((getParent() != null) && ((getParent() instanceof AbstractTreeNode)))
      return 0;
    return 0;
  }

  public void setPos(int paramInt)
  {
    if ((getParent() != null) && ((getParent() instanceof AbstractTreeNode)))
    {
      if (paramInt < 0)
        return;
      int i = getParent().getElementPos(this);
      int j = getPos();
      if (j == paramInt)
        return;
      getParent().removeChildElement(this);
      getParent().addChildElement(this, i + paramInt - j);
    }
  }

  public void replacePos(IElement paramIElement1, IElement paramIElement2)
  {
    int i = getElementPos(paramIElement1);
    paramIElement2.setUuid(paramIElement1.getUuid());
    removeElement(i);
    addChildElement(paramIElement2, i);
  }

  public o getUndoable()
  {
    if (this.undoable == null)
      this.undoable = new o(this);
    return this.undoable;
  }

  public boolean canRedo()
  {
    return getUndoable().canRedo();
  }

  public boolean canUndo()
  {
    return getUndoable().canUndo();
  }

  public boolean redo()
  {
    return getUndoable().redo();
  }

  public void takeSnapshot()
  {
    getUndoable().a(true);
    getUndoable().takeSnapshot();
    getUndoable().a(false);
  }

  public boolean undo()
  {
    return getUndoable().undo();
  }

  public void initUndoable()
  {
    getUndoable().initUndoable();
  }

  private List d()
  {
    if (this.viewer == null)
      this.viewer = new ArrayList(5);
    return this.viewer;
  }

  public IRuleProject getProject()
  {
    if (getParent() != null)
    {
      if ((getParent() instanceof IRuleProject))
        return (IRuleProject)getParent();
      if ((getParent() instanceof ITreeNode))
        return ((ITreeNode)getParent()).getProject();
    }
    return null;
  }

  public String getSrcPath()
  {
    if ((getParent() != null) && ((getParent() instanceof ITreeNode)))
      return ((ITreeNode)getParent()).getSrcPath() + File.separator + getDisplayName();
    return toString();
  }

  public void selfsave(boolean paramBoolean)
  {
    IRuleProject localIRuleProject = getProject();
    if (localIRuleProject != null)
    {
      File localFile = new File(getSrcPath() + "." + getName());
      localFile.getParentFile().mkdirs();
      if (localFile.exists())
        localFile.delete();
      t.a(this, localFile);
      localFile.setLastModified(this.f);
      if (paramBoolean)
        localFile.setReadOnly();
    }
  }

  public void save()
  {
    IRuleProject localIRuleProject = getProject();
    if ((localIRuleProject != null) && (localIRuleProject.isMultiFileSave()))
    {
      File localFile = new File(getSrcPath() + "." + getName());
      localFile.getParentFile().mkdirs();
      if ((this.d) || (!localFile.exists()) || (localFile.lastModified() / 1000L != this.f / 1000L))
      {
        t.a(this, localFile);
        localFile.setLastModified(this.f);
      }
      Iterator localIterator = getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject == null) || (!(localObject instanceof ITreeNode)))
          continue;
        ((ITreeNode)localObject).save();
      }
    }
    else if ((this instanceof IPackageElement))
    {
      if (((IPackageElement)this).getMainPackage() != null)
      {
        ((IPackageElement)this).getMainPackage().save();
        ((IPackageElement)this).getMainPackage().setModified(false);
      }
      else if (((IPackageElement)this).getEnvionment() != null)
      {
        ((IPackageElement)this).getEnvionment().save();
      }
    }
    this.d = false;
  }

  public boolean isLocked()
  {
    IRuleProject localIRuleProject = getProject();
    if ((localIRuleProject != null) && (localIRuleProject.isMultiFileSave()))
    {
      File localFile = new File(getSrcPath() + "." + getName());
      if ((localFile.exists()) && (!localFile.canWrite()))
        return true;
    }
    if (getParent() != null)
      return getParent().isLocked();
    return false;
  }

  public boolean needReload()
  {
    IRuleProject localIRuleProject = getProject();
    if ((localIRuleProject != null) && (localIRuleProject.isMultiFileSave()))
    {
      File localFile = new File(getSrcPath() + "." + getName());
      if ((localFile.exists()) && (localFile.lastModified() > this.fileLastTime))
        try
        {
          ParentInfo localParentInfo = (ParentInfo)new s().load(localFile);
          ITreeNode localITreeNode = (ITreeNode)localParentInfo.getElements();
          return localITreeNode.getModifyTime() > this.f;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
    }
    return false;
  }

  public void reloadFromFile(File paramFile)
  {
    if (paramFile == null)
      paramFile = new File(getSrcPath() + "." + getName());
    if (paramFile.exists())
      try
      {
        ParentInfo localParentInfo = (ParentInfo)new s().load(paramFile);
        ITreeNode localITreeNode1 = (ITreeNode)localParentInfo.getElements();
        ITreeNode localITreeNode2 = (ITreeNode)getParent();
        int i = ((AbstractElement)localITreeNode2).indexOfElement(this);
        dispose();
        localITreeNode2.addChildElement(localITreeNode1, i);
        List localList = localParentInfo.getChildNodeInfos();
        for (int j = 0; j < localList.size(); j++)
        {
          ChildNodeInfo localChildNodeInfo = (ChildNodeInfo)localList.get(j);
          localChildNodeInfo.loadFromFile(localITreeNode1, paramFile.getParent() + File.separator + getDisplayName());
        }
        localITreeNode2.setModified(true);
        b(localITreeNode1);
        localITreeNode2.updateTree();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
  }

  public long getFileLastTime()
  {
    return this.fileLastTime;
  }

  public void setFileLastTime(long paramLong)
  {
    this.fileLastTime = paramLong;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.AbstractTreeNode
 * JD-Core Version:    0.6.0
 */