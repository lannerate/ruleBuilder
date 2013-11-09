package com.flagleader.builder.a.e;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.s;
import com.flagleader.engine.Property;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import java.util.Date;
import java.util.Iterator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class a extends aS
  implements IElementViewer
{
  private Tree e;
  private s f;
  private TreeItem g = null;
  private int q = 0;

  public a(RulePackage paramRulePackage, Composite paramComposite, bu parambu)
  {
    super(paramRulePackage, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new a((RulePackage)this.c, paramComposite, this.a);
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "recompile");
    a(paramToolBar, "rejsp");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "search");
    super.a(paramToolBar);
  }

  protected void h()
  {
    a(new c(this));
    a(new d(this));
    super.h();
  }

  private RulePackage f()
  {
    return (RulePackage)this.c;
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    b(localComposite);
    e();
    return localComposite;
  }

  public void b(Composite paramComposite)
  {
    this.f = new s();
    this.e = this.f.a(paramComposite, 66306);
    this.e.setLayoutData(new GridData(1808));
    this.e.setHeaderVisible(true);
    this.e.setLinesVisible(true);
    this.e.addMouseListener(new b(this));
  }

  public void e()
  {
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.PackageRuleView");
    String[] arrayOfString2 = ResourceTools.getStringArray("lengths.PackageRuleView");
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      TreeColumn localTreeColumn2 = new TreeColumn(this.e, 8388608);
      localTreeColumn2.setText(ResourceTools.getMessage(arrayOfString1[i] + ".PackageRuleView"));
      localTreeColumn2.setWidth(Integer.parseInt(arrayOfString2[i]));
    }
    TreeColumn localTreeColumn1 = new TreeColumn(this.e, 8388608);
    localTreeColumn1.setWidth(50);
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    this.e.removeAll();
    this.q = 1;
    RulePackage localRulePackage = f();
    TreeItem localTreeItem = new TreeItem(this.e, 0);
    localTreeItem.setText(new String[] { localRulePackage.getDisplayName(), localRulePackage.getDocument(), Property.getInstance().formatDatetime(new Date(localRulePackage.getModifyTime())), String.valueOf(this.q++) });
    localTreeItem.setData(localRulePackage);
    a(localRulePackage, localTreeItem);
    Iterator localIterator = localRulePackage.getChildNodes();
    while (localIterator.hasNext())
      a(localTreeItem, (ITreeNode)localIterator.next());
    localTreeItem.setExpanded(true);
    z();
    super.update();
  }

  private void a(TreeItem paramTreeItem, ITreeNode paramITreeNode)
  {
    if (paramITreeNode.isVisible())
    {
      TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
      String str = paramITreeNode.getDocument();
      if (str.length() == 0)
        str = paramITreeNode.getInfo();
      localTreeItem.setText(new String[] { paramITreeNode.getDisplayName(), str, Property.getInstance().formatDatetime(new Date(paramITreeNode.getModifyTime())), String.valueOf(this.q++) });
      a(paramITreeNode, localTreeItem);
      localTreeItem.setData(paramITreeNode);
      Iterator localIterator = paramITreeNode.getChildNodes();
      while (localIterator.hasNext())
        a(localTreeItem, (ITreeNode)localIterator.next());
      localTreeItem.setExpanded(true);
    }
  }

  private void a(ITreeNode paramITreeNode, TreeItem paramTreeItem)
  {
    Image localImage = ResourceTools.getIcon(paramITreeNode);
    if (((paramITreeNode instanceof IRuleTree)) && (((IRuleTree)paramITreeNode).isEmpty()))
      paramTreeItem.setForeground(h.j);
    else if (((paramITreeNode instanceof IRuleTree)) && (((IRuleTree)paramITreeNode).isChangedshint()))
      paramTreeItem.setForeground(h.g);
    if (localImage != null)
      paramTreeItem.setImage(localImage);
  }

  public String getCompositeUuid()
  {
    return f().getEditUuid() + "rules";
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
 * Qualified Name:     com.flagleader.builder.a.e.a
 * JD-Core Version:    0.6.0
 */