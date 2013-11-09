package com.flagleader.builder.a.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.actions.aq;
import com.flagleader.builder.widget.d;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.s;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IConstantObject;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.rom.ISubVariable;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RuleMirror;
import com.flagleader.repository.tree.RuleProject;
import java.util.Iterator;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class I extends aS
  implements IElementViewer
{
  private Tree e;
  private s f;
  private TreeItem g = null;
  private Envionment q;
  private Menu r;

  public I(Envionment paramEnvionment, Composite paramComposite, bu parambu)
  {
    super(paramEnvionment, paramComposite, parambu);
    this.q = paramEnvionment;
  }

  protected aS e(Composite paramComposite)
  {
    return new I((Envionment)this.c, paramComposite, this.a);
  }

  protected Envionment e()
  {
    return this.q;
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    b(localComposite);
    return localComposite;
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "search");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
  }

  protected void h()
  {
    super.h();
  }

  public void b(Composite paramComposite)
  {
    this.f = new s();
    this.e = this.f.a(paramComposite, 66306);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.ProjectRuleView");
    String[] arrayOfString2 = ResourceTools.getStringArray("lengths.ProjectRuleView");
    for (int i = 1; i < 2; i++)
    {
      TreeColumn localTreeColumn = new TreeColumn(this.e, 8388608);
      localTreeColumn.setText(ResourceTools.getMessage(arrayOfString1[i] + ".ProjectRuleView"));
      localTreeColumn.setWidth(Integer.parseInt(arrayOfString2[i]));
    }
    this.e.addMouseListener(new K(this, null));
    DragSource localDragSource = new DragSource(this.e, 3);
    localDragSource.setTransfer(new Transfer[] { d.a() });
    localDragSource.addDragListener(new J(this));
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()))
      return;
    this.e.removeAll();
    Iterator localIterator = e().getChildNodes();
    while (localIterator.hasNext())
      a(this.e, (ITreeNode)localIterator.next());
    super.update();
  }

  private void a(Tree paramTree, ITreeNode paramITreeNode)
  {
    if (((paramITreeNode instanceof RuleProject)) && (!((RuleProject)paramITreeNode).isOpened()))
      return;
    TreeItem localTreeItem = new TreeItem(paramTree, 0);
    a(paramITreeNode, localTreeItem);
    if ((paramITreeNode instanceof IBusinessObjectContainer))
    {
      Iterator localIterator = ((IBusinessObjectContainer)paramITreeNode).getEditens();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (!(localObject instanceof IBusinessObjectEditen))
          continue;
        a(localTreeItem, (IBusinessObjectEditen)localObject);
      }
    }
    a(localTreeItem, paramITreeNode);
  }

  private void a(TreeItem paramTreeItem)
  {
    while (paramTreeItem.getItemCount() > 0)
      paramTreeItem.getItems()[0].dispose();
    c((ITreeNode)paramTreeItem.getData(), paramTreeItem);
    b((ITreeNode)paramTreeItem.getData(), paramTreeItem);
    a(paramTreeItem, (ITreeNode)paramTreeItem.getData());
  }

  private void b(TreeItem paramTreeItem)
  {
    if ((paramTreeItem.getData() != null) && ((paramTreeItem.getData() instanceof ITreeNode)))
    {
      ITreeNode localITreeNode = (ITreeNode)paramTreeItem.getData();
      if (((localITreeNode instanceof IRuleTree)) && (((IRuleTree)localITreeNode).isChangedshint()))
        paramTreeItem.setForeground(h.g);
      String str = localITreeNode.getDisplayName();
      paramTreeItem.setText(a(str));
    }
    for (int i = 0; i < paramTreeItem.getItemCount(); i++)
      b(paramTreeItem.getItem(i));
  }

  private void a(TreeItem paramTreeItem, ITreeNode paramITreeNode)
  {
    Iterator localIterator1 = paramITreeNode.getChildNodes();
    while (localIterator1.hasNext())
    {
      ITreeNode localITreeNode = (ITreeNode)localIterator1.next();
      if ((!localITreeNode.isVisible()) || ((localITreeNode instanceof IRuleTree)))
        continue;
      TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
      a(localITreeNode, localTreeItem);
      if ((localITreeNode instanceof IBusinessObjectContainer))
      {
        Iterator localIterator2 = ((IBusinessObjectContainer)localITreeNode).getEditens();
        while (localIterator2.hasNext())
        {
          Object localObject = localIterator2.next();
          if (!(localObject instanceof IBusinessObjectEditen))
            continue;
          a(localTreeItem, (IBusinessObjectEditen)localObject);
        }
      }
      if (!localITreeNode.hasChildNodes())
        continue;
      a(localTreeItem, localITreeNode);
    }
  }

  private void a(TreeItem paramTreeItem, IBusinessObjectEditen paramIBusinessObjectEditen)
  {
    TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
    localTreeItem.setData(paramIBusinessObjectEditen);
    localTreeItem.setText(a(paramIBusinessObjectEditen.getDisplayName()));
    if ((paramIBusinessObjectEditen instanceof ITreeNode))
      localTreeItem.setImage(ResourceTools.getIcon((ITreeNode)paramIBusinessObjectEditen));
    else if ((paramIBusinessObjectEditen instanceof ISubFunction))
      localTreeItem.setImage(ResourceTools.getImage("classsubfunction.icon"));
    else if ((paramIBusinessObjectEditen instanceof ISubVariable))
      localTreeItem.setImage(ResourceTools.getImage("classsubvariable.icon"));
    else if ((paramIBusinessObjectEditen instanceof IFunctionObject))
      localTreeItem.setImage(ResourceTools.getImage("classfunction.icon"));
    else if ((paramIBusinessObjectEditen instanceof IVariableObject))
      localTreeItem.setImage(ResourceTools.getImage("classvariable.icon"));
    else if ((paramIBusinessObjectEditen instanceof IConstantObject))
      localTreeItem.setImage(ResourceTools.getImage("classenum.icon"));
    if (paramIBusinessObjectEditen.hasSubEditen())
    {
      Iterator localIterator = paramIBusinessObjectEditen.getSubEditens();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (!(localObject instanceof IBusinessObjectEditen))
          continue;
        a(localTreeItem, (IBusinessObjectEditen)localObject);
      }
    }
  }

  protected void a(ITreeNode paramITreeNode, TreeItem paramTreeItem)
  {
    c(paramITreeNode, paramTreeItem);
    b(paramITreeNode, paramTreeItem);
  }

  private void c(ITreeNode paramITreeNode, TreeItem paramTreeItem)
  {
    paramTreeItem.setData(paramITreeNode);
    if (((paramITreeNode instanceof IRuleTree)) && (((IRuleTree)paramITreeNode).isChangedshint()))
      paramTreeItem.setForeground(h.g);
    if ((paramITreeNode instanceof RuleMirror))
      paramTreeItem.setForeground(h.a);
    String str = paramITreeNode.getDisplayName();
    paramTreeItem.setText(a(str));
  }

  private String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return "";
    return paramString;
  }

  public static void b(ITreeNode paramITreeNode, TreeItem paramTreeItem)
  {
    Image localImage = ResourceTools.getIcon(paramITreeNode);
    if (localImage != null)
      paramTreeItem.setImage(localImage);
  }

  protected int f()
  {
    return this.e.getSelectionCount();
  }

  protected IElement[] g()
  {
    if (this.e.getSelectionCount() > 0)
    {
      IElement[] arrayOfIElement = new IElement[this.e.getSelectionCount()];
      TreeItem[] arrayOfTreeItem = this.e.getSelection();
      for (int i = 0; i < arrayOfTreeItem.length; i++)
      {
        if ((arrayOfTreeItem[i].getData() == null) || (!(arrayOfTreeItem[i].getData() instanceof IElement)))
          continue;
        arrayOfIElement[i] = ((IElement)arrayOfTreeItem[i].getData());
      }
      return arrayOfIElement;
    }
    return null;
  }

  public void copy()
  {
    if (f() <= 0)
      return;
    IElement[] arrayOfIElement = g();
    if (arrayOfIElement.length == 1)
    {
      new Clipboard(Display.getCurrent()).setContents(new Object[] { arrayOfIElement[0] }, new Transfer[] { d.a() });
      a().getMessageWindow().a(arrayOfIElement[0]);
    }
    else
    {
      ElementContainer localElementContainer = new ElementContainer();
      for (int i = 0; i < arrayOfIElement.length; i++)
      {
        if ((arrayOfIElement[i] == null) || (!(arrayOfIElement[i] instanceof IBusinessObjectEditen)))
          continue;
        localElementContainer.addChildElement((IBusinessObjectEditen)arrayOfIElement[i]);
      }
      new Clipboard(Display.getCurrent()).setContents(new Object[] { localElementContainer }, new Transfer[] { d.a() });
      a().getMessageWindow().a(localElementContainer);
    }
  }

  public TreeItem i()
  {
    if ((this.e != null) && (this.e.getSelection() != null) && (this.e.getSelection().length == 1))
      return this.e.getSelection()[0];
    return null;
  }

  public TreeItem[] j()
  {
    if ((this.e != null) && (this.e.isFocusControl()))
      return this.e.getSelection();
    return new TreeItem[0];
  }

  public ITreeNode k()
  {
    TreeItem localTreeItem = i();
    if ((localTreeItem != null) && (localTreeItem.getData() != null) && ((localTreeItem.getData() instanceof ITreeNode)))
      return (ITreeNode)localTreeItem.getData();
    return null;
  }

  public String getCompositeUuid()
  {
    return e().getEditUuid() + "rules";
  }

  public boolean needUpdate()
  {
    return super.needUpdate();
  }

  public void find()
  {
    this.f.a();
  }

  public void findNext()
  {
    this.f.b();
  }

  public boolean isCanFind()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.I
 * JD-Core Version:    0.6.0
 */