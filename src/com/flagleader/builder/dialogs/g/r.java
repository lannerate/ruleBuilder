package com.flagleader.builder.dialogs.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.engine.Property;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class r extends com.flagleader.builder.dialogs.r
{
  private List i = new ArrayList();
  private List j = null;
  private com.flagleader.builder.widget.s k = new com.flagleader.builder.widget.s();
  private BuilderManager l;
  private ITreeNode m;
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 0;
  private Tree n;
  private HashMap o = new HashMap();

  public r(BuilderManager paramBuilderManager, List paramList, ITreeNode paramITreeNode)
  {
    super(paramBuilderManager.getShell());
    this.l = paramBuilderManager;
    this.j = paramList;
    this.m = paramITreeNode;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.NodeRuleCheckOutDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(860, 550));
    this.n = this.k.a(localComposite2, 67618);
    this.n.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.NodeRuleCheckOutDialog");
    String[] arrayOfString2 = ResourceTools.getStringArray("types.NodeRuleCheckOutDialog");
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths.NodeRuleCheckOutDialog");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int i1 = 0; i1 < arrayOfString3.length; i1++)
      arrayOfInt[i1] = Integer.parseInt(arrayOfString3[i1]);
    for (i1 = 0; i1 < arrayOfString1.length; i1++)
      arrayOfString1[i1] = a(arrayOfString1[i1] + ".NodeRuleCheckOutDialog");
    this.k.a(arrayOfString1, arrayOfInt, arrayOfString2);
    this.n.setHeaderVisible(true);
    this.n.setLayoutData(new GridData(1808));
    this.n.addSelectionListener(new s(this));
    a(this.m);
    TreeItem localTreeItem = new TreeItem(this.n, 0);
    a(localTreeItem, this.m);
    return localComposite1;
  }

  private void a(TreeItem paramTreeItem, ITreeNode paramITreeNode)
  {
    Image localImage = ResourceTools.getIcon(paramITreeNode);
    if (localImage != null)
      paramTreeItem.setImage(localImage);
    paramTreeItem.setText(0, paramITreeNode.getDisplayName());
    paramTreeItem.setText(1, Property.getInstance().formatDatetime(new Date(paramITreeNode.getModifyTime())));
    List localList = (List)this.o.get(paramITreeNode);
    if (localList != null)
    {
      localObject = (Date)localList.get(5);
      if (((Date)localObject).getTime() / 1000L > paramITreeNode.getModifyTime() / 1000L)
      {
        paramTreeItem.setForeground(com.flagleader.builder.widget.h.g);
        paramTreeItem.setChecked(true);
      }
      else if (((Date)localObject).getTime() / 1000L < paramITreeNode.getModifyTime() / 1000L)
      {
        paramTreeItem.setForeground(com.flagleader.builder.widget.h.h);
      }
      paramTreeItem.setText(2, StringUtil.stringValue(localList.get(6)));
      paramTreeItem.setText(3, StringUtil.stringValue(localList.get(5)));
    }
    else
    {
      paramTreeItem.setChecked(false);
    }
    paramTreeItem.setData(paramITreeNode);
    Object localObject = paramITreeNode.getChildNodes();
    while (((Iterator)localObject).hasNext())
    {
      TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
      a(localTreeItem, (ITreeNode)((Iterator)localObject).next());
    }
    paramTreeItem.setExpanded(true);
  }

  private void a(ITreeNode paramITreeNode)
  {
    for (int i1 = 0; i1 < this.j.size(); i1++)
    {
      List localList = (List)this.j.get(i1);
      if ((paramITreeNode instanceof IRulePackage))
      {
        if ((StringUtil.stringValue(localList.get(2)).length() != 0) || (!StringUtil.stringValue(localList.get(3)).equals(paramITreeNode.getDisplayName())) || (!StringUtil.stringValue(localList.get(4)).equals(paramITreeNode.getName())))
          continue;
        this.o.put(paramITreeNode, localList);
        this.j.remove(localList);
        break;
      }
      if ((!StringUtil.stringValue(localList.get(2)).equals(com.flagleader.manager.a.a.h.a(paramITreeNode.getParent()))) || (!StringUtil.stringValue(localList.get(3)).equals(paramITreeNode.getDisplayName())) || (!StringUtil.stringValue(localList.get(4)).equals(paramITreeNode.getName())))
        continue;
      this.o.put(paramITreeNode, localList);
      this.j.remove(localList);
      break;
    }
    Iterator localIterator = paramITreeNode.getChildNodes();
    while (localIterator.hasNext())
      a((ITreeNode)localIterator.next());
  }

  private void a(TreeItem paramTreeItem, List paramList)
  {
    for (int i1 = 0; i1 < paramList.size(); i1++)
    {
      paramTreeItem.setText(i1, StringUtil.stringValue(paramList.get(i1)));
      String str = (String)this.o.get(paramList);
      if ((str != null) && (str.equals("1")))
        paramTreeItem.setBackground(com.flagleader.builder.widget.h.g);
      else if ((str != null) && (str.equals("2")))
        paramTreeItem.setBackground(com.flagleader.builder.widget.h.h);
      if ((((Integer)paramList.get(7)).intValue() != 0) || (!StringUtil.stringValue(paramList.get(6)).equals(this.l.getUserServer())))
        continue;
      paramTreeItem.setChecked(true);
    }
    paramTreeItem.setData(paramList);
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
    TreeItem[] arrayOfTreeItem = this.n.getItems();
    this.i.clear();
    for (int i1 = 0; i1 < arrayOfTreeItem.length; i1++)
      a(arrayOfTreeItem[i1]);
    super.okPressed();
  }

  public List a()
  {
    return this.i;
  }

  public HashMap b()
  {
    return this.o;
  }

  private void b(TreeItem paramTreeItem)
  {
    if (paramTreeItem.getParentItem() != null)
    {
      paramTreeItem.getParentItem().setChecked(false);
      b(paramTreeItem.getParentItem());
    }
  }

  private void a(TreeItem[] paramArrayOfTreeItem, boolean paramBoolean)
  {
    for (int i1 = 0; (paramArrayOfTreeItem != null) && (i1 < paramArrayOfTreeItem.length); i1++)
    {
      paramArrayOfTreeItem[i1].setChecked(paramBoolean);
      a(paramArrayOfTreeItem[i1].getItems(), paramBoolean);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.g.r
 * JD-Core Version:    0.6.0
 */