package com.flagleader.builder.a.e;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.s;
import com.flagleader.manager.d.b;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class h extends aS
  implements IElementViewer
{
  private Tree e;
  private s f;
  private TreeItem g = null;
  private IRuleGroup q;

  public h(IRuleGroup paramIRuleGroup, Composite paramComposite, bu parambu)
  {
    super(paramIRuleGroup, paramComposite, parambu);
    this.q = paramIRuleGroup;
  }

  protected aS e(Composite paramComposite)
  {
    return new h((IRuleGroup)this.c, paramComposite, this.a);
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    b(localComposite);
    e();
    return localComposite;
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "recompile");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "search");
    super.a(paramToolBar);
  }

  protected void h()
  {
    a(new j(this));
    super.h();
  }

  public void b(Composite paramComposite)
  {
    this.f = new s();
    this.e = this.f.a(paramComposite, 66306);
    this.e.addMouseListener(new i(this));
  }

  public void e()
  {
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.ProjectRuleView");
    String[] arrayOfString2 = ResourceTools.getStringArray("lengths.ProjectRuleView");
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      TreeColumn localTreeColumn = new TreeColumn(this.e, 8388608);
      localTreeColumn.setText(ResourceTools.getMessage(arrayOfString1[i] + ".ProjectRuleView"));
      localTreeColumn.setWidth(Integer.parseInt(arrayOfString2[i]));
    }
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    this.e.removeAll();
    Iterator localIterator1 = this.q.getRulePackages();
    int i = 1;
    while (localIterator1.hasNext())
    {
      RulePackage localRulePackage = (RulePackage)localIterator1.next();
      TreeItem localTreeItem = new TreeItem(this.e, 0);
      localTreeItem.setText(new String[] { String.valueOf(i++), localRulePackage.getDisplayName(), localRulePackage.getExeRulePackageName(), new SimpleDateFormat(b.a().i()).format(new Date(localRulePackage.getModifyTime())) });
      localTreeItem.setData(localRulePackage);
      a(localRulePackage, localTreeItem);
      Iterator localIterator2 = localRulePackage.getChildNodes();
      while (localIterator2.hasNext())
        a(localTreeItem, (ITreeNode)localIterator2.next());
    }
    for (int j = 0; j < this.e.getColumnCount(); j++)
      this.e.getColumns()[j].pack();
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
      localTreeItem.setText(new String[] { "", paramITreeNode.getDisplayName(), str, new SimpleDateFormat(b.a().i()).format(new Date(paramITreeNode.getModifyTime())) });
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
    if (localImage != null)
      paramTreeItem.setImage(localImage);
  }

  public String getCompositeUuid()
  {
    return this.q.getEditUuid() + "rules";
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
 * Qualified Name:     com.flagleader.builder.a.e.h
 * JD-Core Version:    0.6.0
 */