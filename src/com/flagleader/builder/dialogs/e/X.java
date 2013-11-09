package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.s;
import com.flagleader.repository.tree.IRuleClass;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class X extends r
{
  private List i = new ArrayList();
  private IRuleClass j = null;
  private s k = new s();
  private BuilderManager l;
  private ITreeNode m;
  private Button n;
  private boolean o = false;
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 1;
  private Tree p;

  public X(BuilderManager paramBuilderManager, IRuleClass paramIRuleClass, ITreeNode paramITreeNode)
  {
    super(null);
    this.l = paramBuilderManager;
    this.j = paramIRuleClass;
    this.m = paramITreeNode;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.SelectRulesDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(500, 550));
    this.p = this.k.a(localComposite2, 67620);
    this.p.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.NodeRuleCheckInDialog");
    String[] arrayOfString2 = ResourceTools.getStringArray("types.NodeRuleCheckInDialog");
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths.NodeRuleCheckInDialog");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int i1 = 0; i1 < 1; i1++)
      arrayOfInt[i1] = Integer.parseInt(arrayOfString3[i1]);
    for (i1 = 0; i1 < 1; i1++)
      arrayOfString1[i1] = a(arrayOfString1[i1] + ".NodeRuleCheckInDialog");
    this.k.a(arrayOfString1, arrayOfInt, arrayOfString2);
    this.p.setHeaderVisible(true);
    this.p.setLayoutData(new GridData(1808));
    Iterator localIterator = this.m.getChildNodes();
    while (localIterator.hasNext())
    {
      ITreeNode localITreeNode = (ITreeNode)localIterator.next();
      if (((!(localITreeNode instanceof IRuleRepository)) && (!(localITreeNode instanceof IRuleGroup)) && (!(localITreeNode instanceof IRuleClass))) || (((localITreeNode instanceof IRuleTree)) && (!(((IRuleTree)localITreeNode).getParent() instanceof IRulePackage))))
        continue;
      TreeItem localTreeItem = new TreeItem(this.p, 0);
      a(localTreeItem, localITreeNode);
    }
    return localComposite1;
  }

  private void a(TreeItem paramTreeItem, ITreeNode paramITreeNode)
  {
    Image localImage = ResourceTools.getIcon(paramITreeNode);
    if (localImage != null)
      paramTreeItem.setImage(localImage);
    paramTreeItem.setText(0, paramITreeNode.getDisplayName());
    if (paramITreeNode.equals(this.j))
      paramTreeItem.setChecked(true);
    paramTreeItem.setData(paramITreeNode);
    Iterator localIterator = paramITreeNode.getChildNodes();
    while (localIterator.hasNext())
    {
      ITreeNode localITreeNode = (ITreeNode)localIterator.next();
      if (((!(localITreeNode instanceof IRuleRepository)) && (!(localITreeNode instanceof IRuleGroup)) && (!(localITreeNode instanceof IRuleClass))) || (((localITreeNode instanceof IRuleTree)) && (!(((IRuleTree)localITreeNode).getParent() instanceof IRulePackage))))
        continue;
      TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
      a(localTreeItem, localITreeNode);
    }
  }

  private void a(TreeItem paramTreeItem)
  {
    if (paramTreeItem.getChecked())
    {
      this.i.add(paramTreeItem.getData());
    }
    else
    {
      TreeItem[] arrayOfTreeItem = paramTreeItem.getItems();
      for (int i1 = 0; i1 < arrayOfTreeItem.length; i1++)
        a(arrayOfTreeItem[i1]);
    }
  }

  protected void okPressed()
  {
    TreeItem[] arrayOfTreeItem = this.p.getItems();
    this.i.clear();
    for (int i1 = 0; i1 < arrayOfTreeItem.length; i1++)
      a(arrayOfTreeItem[i1]);
    super.okPressed();
  }

  public List a()
  {
    return this.i;
  }

  public boolean b()
  {
    return this.o;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.X
 * JD-Core Version:    0.6.0
 */