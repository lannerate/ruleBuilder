package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.p;
import com.flagleader.manager.a;
import com.flagleader.manager.builder.d;
import com.flagleader.manager.r;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RuleMirror;
import com.flagleader.repository.tree.RuleProject;
import com.flagleader.repository.tree.RuleRepository;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class aO extends Observable
  implements d
{
  private Tree c;
  private BuilderManager d;
  private Text e = null;
  private bd f;
  private Menu g;
  private HashMap h = new HashMap();
  TreeEditor a = null;
  a b = null;

  public aO(BuilderManager paramBuilderManager)
  {
    this.d = paramBuilderManager;
    this.b = paramBuilderManager.getRulesManager().c();
    this.f = new bd(this, paramBuilderManager);
  }

  public TreeItem a()
  {
    if ((this.c != null) && (this.c.getSelection() != null) && (this.c.getSelection().length == 1))
      return this.c.getSelection()[0];
    return null;
  }

  public TreeItem[] b()
  {
    if ((this.c != null) && (this.c.isFocusControl()))
      return this.c.getSelection();
    return new TreeItem[0];
  }

  public ITreeNode c()
  {
    TreeItem localTreeItem = a();
    if ((localTreeItem != null) && (localTreeItem.getData() != null) && ((localTreeItem.getData() instanceof ITreeNode)))
      return (ITreeNode)localTreeItem.getData();
    return null;
  }

  public ITreeNode a(String paramString)
  {
    TreeItem localTreeItem = a();
    if (localTreeItem == null)
      return null;
    ITreeNode localITreeNode = this.b.a((ITreeNode)localTreeItem.getData(), paramString);
    localTreeItem.setExpanded(true);
    TreeItem[] arrayOfTreeItem = localTreeItem.getItems();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
    {
      if (!localITreeNode.equals(arrayOfTreeItem[i].getData()))
        continue;
      b(arrayOfTreeItem[i]);
    }
    return localITreeNode;
  }

  public ITreeNode a(String paramString1, String paramString2)
  {
    TreeItem localTreeItem = a();
    if (localTreeItem == null)
      return null;
    ITreeNode localITreeNode = this.b.a((ITreeNode)localTreeItem.getData(), paramString1, paramString2);
    localTreeItem.setExpanded(true);
    TreeItem[] arrayOfTreeItem = localTreeItem.getItems();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
    {
      if (!localITreeNode.equals(arrayOfTreeItem[i].getData()))
        continue;
      b(arrayOfTreeItem[i]);
    }
    return localITreeNode;
  }

  private TreeItem a(TreeItem paramTreeItem, ITreeNode paramITreeNode)
  {
    if ((paramTreeItem.getData() != null) && ((paramTreeItem.getData() instanceof ITreeNode)) && (paramITreeNode.equals(paramTreeItem.getData())))
      return paramTreeItem;
    TreeItem[] arrayOfTreeItem = paramTreeItem.getItems();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
    {
      TreeItem localTreeItem = a(arrayOfTreeItem[i], paramITreeNode);
      if (localTreeItem != null)
        return localTreeItem;
    }
    return null;
  }

  private TreeItem a(TreeItem paramTreeItem, String paramString)
  {
    if ((paramTreeItem.getData() != null) && ((paramTreeItem.getData() instanceof ITreeNode)) && (((ITreeNode)paramTreeItem.getData()).getUuid().equals(paramString)))
      return paramTreeItem;
    TreeItem[] arrayOfTreeItem = paramTreeItem.getItems();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
    {
      TreeItem localTreeItem = a(arrayOfTreeItem[i], paramString);
      if (localTreeItem != null)
        return localTreeItem;
    }
    return null;
  }

  private TreeItem b(TreeItem paramTreeItem, String paramString)
  {
    if ((paramTreeItem.getData() != null) && ((paramTreeItem.getData() instanceof ITreeNode)) && (((ITreeNode)paramTreeItem.getData()).toString().equals(paramString)))
      return paramTreeItem;
    TreeItem[] arrayOfTreeItem = paramTreeItem.getItems();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
    {
      TreeItem localTreeItem = b(arrayOfTreeItem[i], paramString);
      if (localTreeItem != null)
        return localTreeItem;
    }
    return null;
  }

  private TreeItem c(TreeItem paramTreeItem, String paramString)
  {
    TreeItem localTreeItem;
    if (paramTreeItem == null)
    {
      arrayOfTreeItem = this.c.getItems();
      for (i = 0; i < arrayOfTreeItem.length; i++)
      {
        localTreeItem = c(arrayOfTreeItem[i], paramString);
        if (localTreeItem != null)
          return localTreeItem;
      }
    }
    if ((paramTreeItem.getData() != null) && ((paramTreeItem.getData() instanceof ITreeNode)) && (((ITreeNode)paramTreeItem.getData()).getEditUuid().equals(paramString)))
      return paramTreeItem;
    TreeItem[] arrayOfTreeItem = paramTreeItem.getItems();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
    {
      localTreeItem = c(arrayOfTreeItem[i], paramString);
      if (localTreeItem != null)
        return localTreeItem;
    }
    return null;
  }

  public TreeItem a(ITreeNode paramITreeNode)
  {
    Tree localTree = e();
    TreeItem[] arrayOfTreeItem = localTree.getItems();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
    {
      TreeItem localTreeItem = a(arrayOfTreeItem[i], paramITreeNode);
      if (localTreeItem != null)
        return localTreeItem;
    }
    return null;
  }

  public void a(TreeItem paramTreeItem)
  {
    this.b.i((ITreeNode)paramTreeItem.getData());
  }

  public void d()
  {
    TreeItem localTreeItem = a();
    if (localTreeItem == null)
      return;
    b(localTreeItem);
  }

  public void b(ITreeNode paramITreeNode)
  {
    b(a(paramITreeNode));
  }

  public void b(TreeItem paramTreeItem)
  {
    if (paramTreeItem == null)
      return;
    if ((paramTreeItem.getData() != null) && ((paramTreeItem.getData() instanceof ITreeNode)) && (!((ITreeNode)paramTreeItem.getData()).canRename()))
      return;
    this.a.horizontalAlignment = 16384;
    this.a.grabHorizontal = true;
    this.a.verticalAlignment = 16777224;
    this.a.grabVertical = true;
    this.a.minimumWidth = 60;
    if (this.e != null)
    {
      this.e.dispose();
      this.e = null;
    }
    this.e = new p(this.d).a(e(), 0);
    this.e.setText(paramTreeItem.getText());
    this.e.selectAll();
    this.a.setEditor(this.e, paramTreeItem);
    this.e.setFocus();
    this.e.addTraverseListener(new aP(this, paramTreeItem));
    this.e.addFocusListener(new aQ(this, paramTreeItem));
  }

  private void a(String paramString, TreeItem paramTreeItem)
  {
    if ((paramTreeItem == null) || (paramTreeItem.getData() == null))
      return;
    if (this.b.a(paramString, (ITreeNode)paramTreeItem.getData()))
      paramTreeItem.setText(paramString);
  }

  public void c(TreeItem paramTreeItem)
  {
    this.d.getRuleEditor().a((ITreeNode)paramTreeItem.getData());
    if ((paramTreeItem != null) && (!paramTreeItem.isDisposed()))
      this.c.setSelection(new TreeItem[] { paramTreeItem });
  }

  public void c(ITreeNode paramITreeNode)
  {
    Object localObject = null;
    TreeItem[] arrayOfTreeItem = this.c.getItems();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
    {
      TreeItem localTreeItem = a(arrayOfTreeItem[i], paramITreeNode);
      if (localTreeItem == null)
        continue;
      localObject = localTreeItem;
    }
    if (localObject != null)
    {
      this.c.setFocus();
      c(localObject);
    }
  }

  public void b(String paramString)
  {
    Object localObject = null;
    TreeItem[] arrayOfTreeItem = this.c.getItems();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
    {
      TreeItem localTreeItem = b(arrayOfTreeItem[i], paramString);
      if (localTreeItem == null)
        continue;
      localObject = localTreeItem;
    }
    if (localObject != null)
    {
      this.c.setFocus();
      c(localObject);
    }
  }

  public void c(String paramString)
  {
    Object localObject = null;
    TreeItem[] arrayOfTreeItem = this.c.getItems();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
    {
      TreeItem localTreeItem = a(arrayOfTreeItem[i], paramString);
      if (localTreeItem == null)
        continue;
      localObject = localTreeItem;
    }
    if (localObject != null)
    {
      this.c.setFocus();
      c(localObject);
    }
  }

  protected void d(ITreeNode paramITreeNode)
  {
    setChanged();
    notifyObservers();
  }

  private void k()
  {
    setChanged();
    notifyObservers();
  }

  public Tree e()
  {
    return this.c;
  }

  public void a(Composite paramComposite)
  {
    this.c = new Tree(paramComposite, 2818);
    IRuleRepository localIRuleRepository = this.d.getRulesManager().d();
    if (localIRuleRepository != null)
      a(localIRuleRepository);
    this.c.setLayout(h.a(1));
    this.c.setLayoutData(new GridData(1808));
    this.a = new TreeEditor(e());
    this.c.addMouseListener(new aR(this));
    this.c.addFocusListener(new aY(this));
    addObserver(this.d.getMenuAndToolBar());
    DragSource localDragSource = new DragSource(this.c, 3);
    localDragSource.setTransfer(new Transfer[] { TextTransfer.getInstance() });
    localDragSource.addDragListener(new aZ(this));
    DropTarget localDropTarget = new DropTarget(this.c, 19);
    localDropTarget.setTransfer(new Transfer[] { TextTransfer.getInstance(), FileTransfer.getInstance() });
    localDropTarget.addDropListener(new ba(this));
  }

  public void f()
  {
    TreeItem[] arrayOfTreeItem = this.c.getSelection();
    ITreeNode[] arrayOfITreeNode = new ITreeNode[arrayOfTreeItem.length];
    for (int i = 0; i < arrayOfTreeItem.length; i++)
      arrayOfITreeNode[i] = ((ITreeNode)arrayOfTreeItem[i].getData());
    this.b.b(arrayOfITreeNode);
  }

  public void g()
  {
    TreeItem[] arrayOfTreeItem = this.c.getSelection();
    ITreeNode[] arrayOfITreeNode = new ITreeNode[arrayOfTreeItem.length];
    for (int i = 0; i < arrayOfTreeItem.length; i++)
      arrayOfITreeNode[i] = ((ITreeNode)arrayOfTreeItem[i].getData());
    this.b.a(arrayOfITreeNode, false);
  }

  public void h()
  {
    TreeItem[] arrayOfTreeItem = b();
    String str = " ";
    for (int i = 0; i < arrayOfTreeItem.length; i++)
      str = str + arrayOfTreeItem[i].getText() + " ";
    if (MessageDialog.openQuestion(this.d.getShell(), "", ResourceTools.formatMessage("to_delete", new String[] { str })))
    {
      ITreeNode localITreeNode = (ITreeNode)((IElement)arrayOfTreeItem[0].getData()).getParent();
      ITreeNode[] arrayOfITreeNode = new ITreeNode[arrayOfTreeItem.length];
      for (int j = arrayOfTreeItem.length - 1; j >= 0; j--)
        arrayOfITreeNode[j] = ((ITreeNode)arrayOfTreeItem[j].getData());
      this.b.a(arrayOfITreeNode);
      localITreeNode.updateTree();
    }
  }

  private void l()
  {
    if (this.c != null)
    {
      this.c.removeAll();
      this.d.getRuleEditor().h();
    }
  }

  public void i()
  {
    if (this.c != null)
    {
      l();
      a(this.d.getRulesManager().d());
    }
  }

  private void a(IRuleRepository paramIRuleRepository)
  {
    if (paramIRuleRepository == null)
      l();
    if ((paramIRuleRepository instanceof RuleRepository))
    {
      Iterator localIterator = paramIRuleRepository.getChildNodes();
      while (localIterator.hasNext())
        a(this.c, (ITreeNode)localIterator.next());
    }
    else
    {
      a(this.c, paramIRuleRepository);
    }
    if ((paramIRuleRepository instanceof RuleRepository))
      paramIRuleRepository.setElementEditor(new bb(this, paramIRuleRepository));
  }

  private void a(Tree paramTree, ITreeNode paramITreeNode)
  {
    if (((paramITreeNode instanceof RuleProject)) && (!((RuleProject)paramITreeNode).isOpened()))
      return;
    TreeItem localTreeItem = new TreeItem(paramTree, 0);
    a(paramITreeNode, localTreeItem);
    b(localTreeItem, paramITreeNode);
  }

  private void d(TreeItem paramTreeItem)
  {
    while (paramTreeItem.getItemCount() > 0)
      paramTreeItem.getItems()[0].dispose();
    c((ITreeNode)paramTreeItem.getData(), paramTreeItem);
    b((ITreeNode)paramTreeItem.getData(), paramTreeItem);
    b(paramTreeItem, (ITreeNode)paramTreeItem.getData());
  }

  private void e(TreeItem paramTreeItem)
  {
    if ((paramTreeItem.getData() != null) && ((paramTreeItem.getData() instanceof ITreeNode)))
    {
      ITreeNode localITreeNode = (ITreeNode)paramTreeItem.getData();
      if (((localITreeNode instanceof IRuleTree)) && (((IRuleTree)localITreeNode).isChangedshint()))
        paramTreeItem.setForeground(h.g);
      String str = localITreeNode.getDisplayName();
      paramTreeItem.setText(d(str));
    }
    for (int i = 0; i < paramTreeItem.getItemCount(); i++)
      e(paramTreeItem.getItem(i));
  }

  private void b(TreeItem paramTreeItem, ITreeNode paramITreeNode)
  {
    Iterator localIterator = paramITreeNode.getChildNodes();
    while (localIterator.hasNext())
    {
      ITreeNode localITreeNode = (ITreeNode)localIterator.next();
      if (!localITreeNode.isVisible())
        continue;
      TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
      a(localITreeNode, localTreeItem);
      if (!localITreeNode.hasChildNodes())
        continue;
      b(localTreeItem, localITreeNode);
    }
  }

  protected void a(ITreeNode paramITreeNode, TreeItem paramTreeItem)
  {
    c(paramITreeNode, paramTreeItem);
    b(paramITreeNode, paramTreeItem);
    paramITreeNode.setElementEditor(new bc(this, paramTreeItem, paramITreeNode));
  }

  private void c(ITreeNode paramITreeNode, TreeItem paramTreeItem)
  {
    paramTreeItem.setData(paramITreeNode);
    if (((paramITreeNode instanceof IRuleTree)) && (((IRuleTree)paramITreeNode).isChangedshint()))
      paramTreeItem.setForeground(h.g);
    if ((paramITreeNode instanceof RuleMirror))
      paramTreeItem.setForeground(h.a);
    String str = paramITreeNode.getDisplayName();
    paramTreeItem.setText(d(str));
  }

  public static void b(ITreeNode paramITreeNode, TreeItem paramTreeItem)
  {
    Image localImage = ResourceTools.getIcon(paramITreeNode);
    if (localImage != null)
      paramTreeItem.setImage(localImage);
  }

  public void j()
  {
    c(a());
  }

  private String d(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return "";
    return paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.aO
 * JD-Core Version:    0.6.0
 */