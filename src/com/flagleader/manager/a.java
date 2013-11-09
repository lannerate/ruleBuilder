package com.flagleader.manager;

import com.flagleader.manager.a.k;
import com.flagleader.manager.e.W;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.m;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.ClassContainer;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.InterfaceContainer;
import com.flagleader.repository.tree.RuleGroup;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.TestCaseLib;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlNode;
import java.io.File;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.StateEdit;
import javax.swing.undo.StateEditable;
import javax.swing.undo.UndoManager;

public class a
{
  r a = null;
  k b = null;
  com.flagleader.manager.a.e c = null;
  com.flagleader.manager.a.c d = null;
  protected transient UndoManager e = new UndoManager();
  private transient StateEdit f;

  public a(r paramr)
  {
    this.a = paramr;
    this.b = new k(paramr);
    this.c = new com.flagleader.manager.a.e(paramr);
    this.d = new com.flagleader.manager.a.c(paramr);
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode instanceof IRuleProject))
      this.b.a((IRuleProject)paramITreeNode);
    else if ((paramITreeNode instanceof RulePackage))
      this.c.a((IRulePackage)paramITreeNode);
    return true;
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (!d(paramITreeNode))
      return;
    ITreeNode localITreeNode = paramITreeNode.copy();
    if ((paramITreeNode.getParent() instanceof ITreeNode))
    {
      ((ITreeNode)paramITreeNode.getParent()).setModified(true);
      this.f = new StateEdit(new com.flagleader.repository.tree.a.a((ITreeNode)paramITreeNode.getParent(), localITreeNode, ((ITreeNode)paramITreeNode.getParent()).getElementPos(paramITreeNode)));
      this.e.addEdit(this.f);
      this.f.end();
    }
    paramITreeNode.disposeAndUpdate();
    this.a.b().copy(localITreeNode);
  }

  public void a(StateEditable paramStateEditable)
  {
    this.f = new StateEdit(paramStateEditable);
    this.e.addEdit(this.f);
    this.f.end();
  }

  public void c(ITreeNode paramITreeNode)
  {
    if (!e(paramITreeNode))
      return;
    ITreeNode localITreeNode = paramITreeNode.copy();
    localITreeNode.setModified(true);
    this.a.b().copy(localITreeNode);
  }

  public boolean d(ITreeNode paramITreeNode)
  {
    if (paramITreeNode == null)
      return false;
    if (paramITreeNode.isLocked())
      return false;
    return paramITreeNode.canCut();
  }

  public boolean e(ITreeNode paramITreeNode)
  {
    return paramITreeNode.canCopy();
  }

  public IElement a()
  {
    IElement localIElement = this.a.b().paste();
    if (localIElement != null)
      return localIElement.deepClone();
    return null;
  }

  public boolean b()
  {
    return this.a.b().paste() != null;
  }

  public void a(IRulePackage paramIRulePackage, PrintWriter paramPrintWriter)
  {
    m.a().f().a(paramIRulePackage, paramPrintWriter);
  }

  public void f(ITreeNode paramITreeNode)
  {
    Object localObject;
    if ((paramITreeNode instanceof IRulePackage))
    {
      localObject = this.a.l().a((IRulePackage)paramITreeNode, ((IRulePackage)paramITreeNode).getCompilePath(), com.flagleader.manager.d.b.a().z(), true);
    }
    else if ((paramITreeNode instanceof IRuleRepository))
    {
      localObject = ((IRuleRepository)paramITreeNode).getAcceptElements(new b(this));
      while (((Iterator)localObject).hasNext())
        f((IRulePackage)((Iterator)localObject).next());
    }
    else if ((paramITreeNode instanceof IRuleGroup))
    {
      localObject = ((IRuleGroup)paramITreeNode).getAcceptElements(new c(this));
      while (((Iterator)localObject).hasNext())
        f((IRulePackage)((Iterator)localObject).next());
    }
  }

  public void g(ITreeNode paramITreeNode)
  {
    Iterator localIterator;
    if ((paramITreeNode instanceof IRulePackage))
    {
      localIterator = ((IRulePackage)paramITreeNode).getAcceptChildren(new d(this));
      while (localIterator.hasNext())
        W localW = this.a.l().a((IPage)localIterator.next(), com.flagleader.manager.d.b.a().e(), com.flagleader.manager.d.b.a().A(), true);
    }
    else if ((paramITreeNode instanceof IRuleRepository))
    {
      localIterator = ((IRuleRepository)paramITreeNode).getAcceptElements(new e(this));
      while (localIterator.hasNext())
        g((IRulePackage)localIterator.next());
    }
    else if ((paramITreeNode instanceof IRuleGroup))
    {
      localIterator = ((IRuleGroup)paramITreeNode).getAcceptElements(new f(this));
      while (localIterator.hasNext())
        g((IRulePackage)localIterator.next());
    }
  }

  public void h(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode instanceof IRulePackage))
    {
      this.c.b((IRulePackage)paramITreeNode);
    }
    else if ((paramITreeNode instanceof IPage))
    {
      if (com.flagleader.manager.d.b.a().q())
        this.a.l().a((IPage)paramITreeNode, com.flagleader.manager.d.b.a().e(), com.flagleader.manager.d.b.a().A(), false);
      paramITreeNode.save();
    }
    else if ((paramITreeNode instanceof IPackageElement))
    {
      paramITreeNode.save();
      this.a.j().c(com.flagleader.manager.d.c.a("HasBeenSaved", new String[] { paramITreeNode.toString() }));
    }
    else
    {
      Iterator localIterator;
      Object localObject;
      if ((paramITreeNode instanceof IRuleRepository))
      {
        localIterator = ((IRuleRepository)paramITreeNode).getAcceptElements(new g(this));
        while (localIterator.hasNext())
        {
          localObject = localIterator.next();
          if ((localObject instanceof IRulePackage))
          {
            this.c.b((IRulePackage)localObject);
          }
          else
          {
            if (!(localObject instanceof TestCaseLib))
              continue;
            ((TestCaseLib)localObject).save();
          }
        }
      }
      else if ((paramITreeNode instanceof IRuleGroup))
      {
        localIterator = ((IRuleGroup)paramITreeNode).getAcceptElements(new h(this));
        while (localIterator.hasNext())
        {
          localObject = localIterator.next();
          if ((localObject instanceof IRulePackage))
          {
            this.c.b((IRulePackage)localObject);
          }
          else
          {
            if (!(localObject instanceof TestCaseLib))
              continue;
            ((TestCaseLib)localObject).save();
          }
        }
      }
    }
  }

  public ITreeNode a(ITreeNode paramITreeNode, String paramString)
  {
    if (paramITreeNode.isLocked())
      return null;
    ITreeNode localITreeNode = paramITreeNode.createChildNode(paramString);
    if (localITreeNode == null)
      return null;
    localITreeNode.setModified(true);
    paramITreeNode.setModified(true);
    paramITreeNode.updateTree();
    return localITreeNode;
  }

  public ITreeNode a(ITreeNode paramITreeNode, String paramString1, String paramString2)
  {
    if (paramITreeNode.isLocked())
      return null;
    ITreeNode localITreeNode = paramITreeNode.createChildNode(paramString1);
    if (localITreeNode == null)
      return null;
    if ((paramString2 != null) && (paramString2.length() > 0))
      localITreeNode.setDisplayName(paramString2);
    localITreeNode.setModified(true);
    paramITreeNode.setModified(true);
    paramITreeNode.updateTree();
    return localITreeNode;
  }

  public void i(ITreeNode paramITreeNode)
  {
    if (paramITreeNode.getParent() != null)
    {
      if ((((ITreeNode)paramITreeNode.getParent()).isLocked()) || (paramITreeNode.isLocked()))
        return;
      this.f = new StateEdit(new com.flagleader.repository.tree.a.a((ITreeNode)paramITreeNode.getParent(), (ITreeNode)paramITreeNode.deepClone(), ((ITreeNode)paramITreeNode.getParent()).getElementPos(paramITreeNode)));
      this.e.addEdit(this.f);
      this.f.end();
      ((ITreeNode)paramITreeNode.getParent()).setModified(true);
    }
    if ((paramITreeNode instanceof RulePackage))
      this.c.c((IRulePackage)paramITreeNode);
    else if ((paramITreeNode instanceof RuleGroup))
      paramITreeNode.disposeAndUpdate();
    else if ((paramITreeNode instanceof IPackageElement))
      paramITreeNode.disposeAndUpdate();
    else if ((paramITreeNode instanceof IRuleProject))
      this.a.c().a(paramITreeNode);
  }

  public void a(ITreeNode[] paramArrayOfITreeNode)
  {
    for (int i = 0; i < paramArrayOfITreeNode.length; i++)
    {
      ITreeNode localITreeNode = paramArrayOfITreeNode[i];
      if (localITreeNode.getParent() != null)
      {
        if ((((ITreeNode)localITreeNode.getParent()).isLocked()) || (localITreeNode.isLocked()))
          return;
        this.f = new StateEdit(new com.flagleader.repository.tree.a.a((ITreeNode)localITreeNode.getParent(), (ITreeNode)localITreeNode.deepClone(), ((ITreeNode)localITreeNode.getParent()).getElementPos(localITreeNode)));
        this.e.addEdit(this.f);
        this.f.end();
        ((ITreeNode)localITreeNode.getParent()).setModified(true);
      }
      if ((localITreeNode instanceof RulePackage))
      {
        this.c.c((IRulePackage)localITreeNode);
      }
      else if ((localITreeNode instanceof RuleGroup))
      {
        localITreeNode.disposeAndUpdate();
      }
      else if ((localITreeNode instanceof IPackageElement))
      {
        localITreeNode.disposeAndUpdate();
      }
      else
      {
        if (!(localITreeNode instanceof IRuleProject))
          continue;
        this.a.c().a(localITreeNode);
      }
    }
  }

  public boolean a(String paramString, ITreeNode paramITreeNode)
  {
    if (paramITreeNode.isLocked())
      return false;
    if (!paramITreeNode.getDisplayName().equals(paramString))
    {
      if ((paramITreeNode instanceof RulePackage))
      {
        RulePackage localRulePackage = (RulePackage)paramITreeNode;
        if (localRulePackage.getProject() != null)
        {
          if (!localRulePackage.getProject().canChangePackName(localRulePackage))
          {
            this.a.b().showError(com.flagleader.manager.d.c.b("changePackNameError"));
            return false;
          }
          if (localRulePackage.getExeRulePackageName().equals(localRulePackage.getDisplayName()))
          {
            if ((localRulePackage.getProject() != null) && (localRulePackage.getProject().exitsPackage(paramString.toString()) != null))
            {
              this.a.b().showError(com.flagleader.manager.d.c.b("exitsPackage.RulePackagePropertiesEditor"));
              return false;
            }
            if (new File(localRulePackage.getFilePathName()).exists())
              this.a.b().showQuestion(com.flagleader.manager.d.c.b("deleteFile.RulePackagePropertiesEditor"), new i(this, localRulePackage));
            localRulePackage.setExeRulePackageName(paramString.toString());
          }
          localRulePackage.setDisplayName(paramString);
          localRulePackage.setModified(true);
          localRulePackage.getProject().setNeedSave(true);
        }
      }
      else if ((paramITreeNode instanceof IBOAndContainer))
      {
        ((IBOAndContainer)paramITreeNode).changeDisplayName(paramString);
        ((IBOAndContainer)paramITreeNode).updateViewer();
      }
      else if ((paramITreeNode instanceof CustomSql))
      {
        ((CustomSql)paramITreeNode).changeDisplayName(paramString);
        ((CustomSql)paramITreeNode).getDBModel().updateViewer();
      }
      else if ((paramITreeNode instanceof XmlNode))
      {
        ((XmlNode)paramITreeNode).changeDisplayName(paramString);
        ((XmlNode)paramITreeNode).updateFunction();
        ((XmlNode)paramITreeNode).updateViewer();
      }
      else if ((paramITreeNode instanceof TreeValueNode))
      {
        paramITreeNode.changeDisplayName(paramString);
        ((TreeValueNode)paramITreeNode).resetFunction();
        ((TreeValueNode)paramITreeNode).updateViewer();
      }
      else if ((paramITreeNode instanceof ClassContainer))
      {
        paramITreeNode.changeDisplayName(paramString);
        ((ClassContainer)paramITreeNode).resetFunction();
        ((ClassContainer)paramITreeNode).updateViewer();
      }
      else if ((paramITreeNode instanceof InterfaceContainer))
      {
        paramITreeNode.changeDisplayName(paramString);
        ((InterfaceContainer)paramITreeNode).resetFunction();
        ((InterfaceContainer)paramITreeNode).updateViewer();
      }
      else if ((paramITreeNode instanceof SoapService))
      {
        paramITreeNode.changeDisplayName(paramString);
        ((SoapService)paramITreeNode).updateFunction();
        ((SoapService)paramITreeNode).updateViewer();
      }
      else
      {
        paramITreeNode.changeDisplayName(paramString);
      }
      paramITreeNode.setModified(true);
      return true;
    }
    return false;
  }

  public void b(ITreeNode[] paramArrayOfITreeNode)
  {
    ElementContainer localElementContainer = new ElementContainer();
    ITreeNode localITreeNode = null;
    if ((paramArrayOfITreeNode.length > 0) && ((paramArrayOfITreeNode[0].getParent() instanceof ITreeNode)))
      localITreeNode = (ITreeNode)paramArrayOfITreeNode[0].getParent();
    if ((localITreeNode != null) && (localITreeNode.isLocked()))
      return;
    for (int i = 0; i < paramArrayOfITreeNode.length; i++)
    {
      if ((paramArrayOfITreeNode[i] == null) || (!(paramArrayOfITreeNode[i] instanceof ITreeNode)) || (!paramArrayOfITreeNode[i].getParent().equals(localITreeNode)) || (paramArrayOfITreeNode[i].isLocked()))
        continue;
      localElementContainer.addChildElement(paramArrayOfITreeNode[i].deepClone());
      paramArrayOfITreeNode[i].dispose();
    }
    this.a.b().copy(localElementContainer);
    localITreeNode.setModified(true);
    localITreeNode.updateTree();
  }

  public void a(ITreeNode[] paramArrayOfITreeNode, boolean paramBoolean)
  {
    ElementContainer localElementContainer = new ElementContainer();
    IPackageElement localIPackageElement = null;
    if ((paramArrayOfITreeNode.length > 0) && ((paramArrayOfITreeNode[0].getParent() instanceof IPackageElement)))
      localIPackageElement = (IPackageElement)paramArrayOfITreeNode[0].getParent();
    for (int i = 0; i < paramArrayOfITreeNode.length; i++)
    {
      if ((paramArrayOfITreeNode[i] == null) || (!(paramArrayOfITreeNode[i] instanceof ITreeNode)))
        continue;
      localElementContainer.addChildElement(paramArrayOfITreeNode[i].deepClone());
      if ((!(paramArrayOfITreeNode[i] instanceof IRuleTree)) || (!paramBoolean))
        continue;
      HashMap localHashMap = new HashMap();
      ((IRuleTree)paramArrayOfITreeNode[i]).getRelateObjectMap(localHashMap);
      localElementContainer.copyNotSameChild(localHashMap);
    }
    this.a.b().copy(localElementContainer);
  }

  public k c()
  {
    return this.b;
  }

  public com.flagleader.manager.a.e d()
  {
    return this.c;
  }

  public void a(IElement paramIElement)
  {
    if ((paramIElement instanceof IRulePackage))
      this.a.l().a((IRulePackage)paramIElement);
    else if ((paramIElement instanceof IPackageElement))
      this.a.l().a((IPackageElement)paramIElement, false);
  }

  public boolean j(ITreeNode paramITreeNode)
  {
    if (paramITreeNode == null)
      return false;
    if (paramITreeNode.isLocked())
      return false;
    return (paramITreeNode instanceof Envionment);
  }

  public com.flagleader.manager.a.c e()
  {
    return this.d;
  }

  public boolean f()
  {
    try
    {
      if (h())
        this.e.undo();
      return true;
    }
    catch (CannotUndoException localCannotUndoException)
    {
      System.out.println("Can't undo");
    }
    return false;
  }

  public boolean g()
  {
    try
    {
      if (i())
        this.e.redo();
      return true;
    }
    catch (CannotRedoException localCannotRedoException)
    {
      System.out.println("Can't redo");
    }
    return false;
  }

  public boolean h()
  {
    if (this.e == null)
      return false;
    return this.e.canUndo();
  }

  public boolean i()
  {
    if (this.e == null)
      return false;
    return this.e.canRedo();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a
 * JD-Core Version:    0.6.0
 */