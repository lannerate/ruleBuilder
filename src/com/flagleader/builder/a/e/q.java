package com.flagleader.builder.a.e;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.h;
import com.flagleader.manager.a;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RuleMirror;
import com.flagleader.repository.tree.RuleProject;
import java.util.Iterator;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class q extends aS
  implements IElementViewer
{
  private Tree e;
  private com.flagleader.builder.widget.s f;
  private TreeItem g = null;
  private IRuleRepository q;
  private Menu r;

  public q(IRuleRepository paramIRuleRepository, Composite paramComposite, bu parambu)
  {
    super(paramIRuleRepository, paramComposite, parambu);
    this.q = paramIRuleRepository;
  }

  protected aS e(Composite paramComposite)
  {
    return new q((IRuleRepository)this.c, paramComposite, this.a);
  }

  protected IRuleRepository e()
  {
    if (this.q != null)
      return this.q;
    return a().getRulesManager().d();
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
    this.f = new com.flagleader.builder.widget.s();
    this.e = this.f.a(paramComposite, 66306);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.ProjectRuleView");
    String[] arrayOfString2 = ResourceTools.getStringArray("lengths.ProjectRuleView");
    for (int i = 1; i < 2; i++)
    {
      TreeColumn localTreeColumn = new TreeColumn(this.e, 8388608);
      localTreeColumn.setText(ResourceTools.getMessage(arrayOfString1[i] + ".ProjectRuleView"));
      localTreeColumn.setWidth(Integer.parseInt(arrayOfString2[i]));
    }
    this.e.addMouseListener(new s(this, null));
    DragSource localDragSource = new DragSource(this.e, 3);
    localDragSource.setTransfer(new Transfer[] { TextTransfer.getInstance() });
    localDragSource.addDragListener(new r(this));
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
      a(localTreeItem, localITreeNode);
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

  public ITreeNode f()
  {
    TreeItem[] arrayOfTreeItem = this.e.getSelection();
    if (arrayOfTreeItem.length > 0)
      return (ITreeNode)arrayOfTreeItem[0].getData();
    return null;
  }

  public void a(boolean paramBoolean)
  {
    TreeItem[] arrayOfTreeItem = this.e.getSelection();
    ITreeNode[] arrayOfITreeNode = new ITreeNode[arrayOfTreeItem.length];
    for (int i = 0; i < arrayOfTreeItem.length; i++)
      arrayOfITreeNode[i] = ((ITreeNode)arrayOfTreeItem[i].getData());
    a().getRulesManager().c().a(arrayOfITreeNode, paramBoolean);
  }

  public void copy()
  {
    a(false);
  }

  public TreeItem g()
  {
    if ((this.e != null) && (this.e.getSelection() != null) && (this.e.getSelection().length == 1))
      return this.e.getSelection()[0];
    return null;
  }

  public TreeItem[] i()
  {
    if ((this.e != null) && (this.e.isFocusControl()))
      return this.e.getSelection();
    return new TreeItem[0];
  }

  public ITreeNode j()
  {
    TreeItem localTreeItem = g();
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

  public void a(IRuleRepository paramIRuleRepository)
  {
    this.q = paramIRuleRepository;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.e.q
 * JD-Core Version:    0.6.0
 */