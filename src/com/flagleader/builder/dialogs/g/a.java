package com.flagleader.builder.dialogs.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.s;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class a extends r
{
  private List i = new ArrayList();
  private List j = null;
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
  private HashMap q = new HashMap();

  public a(BuilderManager paramBuilderManager, List paramList, ITreeNode paramITreeNode)
  {
    super(paramBuilderManager.getShell());
    this.l = paramBuilderManager;
    this.j = paramList;
    this.m = paramITreeNode;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.NodeRuleCheckInDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(860, 550));
    this.p = this.k.a(localComposite2, 67618);
    this.p.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.NodeRuleCheckInDialog");
    String[] arrayOfString2 = ResourceTools.getStringArray("types.NodeRuleCheckInDialog");
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths.NodeRuleCheckInDialog");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int i1 = 0; i1 < arrayOfString3.length; i1++)
      arrayOfInt[i1] = Integer.parseInt(arrayOfString3[i1]);
    for (i1 = 0; i1 < arrayOfString1.length; i1++)
      arrayOfString1[i1] = a(arrayOfString1[i1] + ".NodeRuleCheckInDialog");
    this.k.a(arrayOfString1, arrayOfInt, arrayOfString2);
    this.p.setHeaderVisible(true);
    this.p.setLayoutData(new GridData(1808));
    a(this.m, "");
    for (i1 = 0; (this.j != null) && (i1 < this.j.size()); i1++)
      a((List)this.j.get(i1));
    this.n = new Button(localComposite1, 32);
    this.n.setText(a("forcecheckin.NodeRuleCheckInDialog"));
    return localComposite1;
  }

  private void a(List paramList)
  {
    Object localObject;
    if (this.p.getItemCount() == 0)
    {
      localObject = new TreeItem(this.p, 0);
      a((TreeItem)localObject, paramList);
    }
    else
    {
      localObject = StringUtil.stringValue(paramList.get(2));
      String str = StringUtil.stringValue(paramList.get(1));
      TreeItem localTreeItem1 = a(null, str, (String)localObject);
      TreeItem localTreeItem2;
      if (localTreeItem1 == null)
      {
        localTreeItem2 = new TreeItem(this.p, 0);
        a(localTreeItem2, paramList);
      }
      else
      {
        localTreeItem2 = new TreeItem(localTreeItem1, 0);
        a(localTreeItem2, paramList);
      }
    }
  }

  private TreeItem a(TreeItem paramTreeItem, String paramString1, String paramString2)
  {
    int i1;
    TreeItem localTreeItem1;
    String str;
    TreeItem localTreeItem2;
    if (paramTreeItem == null)
      for (i1 = 0; i1 < this.p.getItemCount(); i1++)
      {
        localTreeItem1 = this.p.getItem(i1);
        str = "";
        if (localTreeItem1.getText(2).length() == 0)
          str = localTreeItem1.getText(3) + "." + localTreeItem1.getText(4);
        else
          str = localTreeItem1.getText(2) + "/" + localTreeItem1.getText(3) + "." + localTreeItem1.getText(4);
        if ((localTreeItem1.getText(1).equals(paramString1)) && (str.equals(paramString2)))
          return localTreeItem1;
        localTreeItem2 = a(localTreeItem1, paramString1, paramString2);
        if (localTreeItem2 != null)
          return localTreeItem2;
      }
    else
      for (i1 = 0; i1 < paramTreeItem.getItemCount(); i1++)
      {
        localTreeItem1 = paramTreeItem.getItem(i1);
        str = "";
        if (localTreeItem1.getText(2).length() == 0)
          str = localTreeItem1.getText(3) + "." + localTreeItem1.getText(4);
        else
          str = localTreeItem1.getText(2) + "/" + localTreeItem1.getText(3) + "." + localTreeItem1.getText(4);
        if ((localTreeItem1.getText(1).equals(paramString1)) && (str.equals(paramString2)))
          return localTreeItem1;
        localTreeItem2 = a(localTreeItem1, paramString1, paramString2);
        if (localTreeItem2 != null)
          return localTreeItem2;
      }
    return null;
  }

  private void a(ITreeNode paramITreeNode, String paramString)
  {
    for (int i1 = 0; i1 < this.j.size(); i1++)
    {
      List localList = (List)this.j.get(i1);
      if ((paramITreeNode instanceof IRulePackage))
      {
        if ((StringUtil.stringValue(localList.get(2)).length() != 0) || (!StringUtil.stringValue(localList.get(1)).equals(paramITreeNode.getDisplayName())) || (!StringUtil.stringValue(localList.get(4)).equals(paramITreeNode.getName())))
          continue;
        localDate = (Date)localList.get(5);
        if (localDate.getTime() / 1000L < paramITreeNode.getModifyTime() / 1000L)
        {
          this.q.put(localList, "1");
          break;
        }
        if (localDate.getTime() / 1000L <= paramITreeNode.getModifyTime() / 1000L)
          break;
        this.q.put(localList, "2");
        break;
      }
      if ((!StringUtil.stringValue(localList.get(2)).equals(paramString)) || (!StringUtil.stringValue(localList.get(1)).equals(paramITreeNode.getDisplayName())) || (!StringUtil.stringValue(localList.get(4)).equals(paramITreeNode.getName())))
        continue;
      Date localDate = (Date)localList.get(5);
      if (localDate.getTime() / 1000L < paramITreeNode.getModifyTime() / 1000L)
      {
        this.q.put(localList, "1");
        break;
      }
      if (localDate.getTime() / 1000L <= paramITreeNode.getModifyTime() / 1000L)
        break;
      this.q.put(localList, "2");
      break;
    }
    Iterator localIterator = paramITreeNode.getChildNodes();
    while (localIterator.hasNext())
      a((ITreeNode)localIterator.next(), paramITreeNode.getSrcPath());
  }

  private void a(TreeItem paramTreeItem, List paramList)
  {
    for (int i1 = 0; i1 < paramList.size(); i1++)
    {
      paramTreeItem.setText(i1, StringUtil.stringValue(paramList.get(i1)));
      String str = (String)this.q.get(paramList);
      if ((str != null) && (str.equals("1")))
        paramTreeItem.setBackground(h.g);
      else if ((str != null) && (str.equals("2")))
        paramTreeItem.setBackground(h.h);
      if ((((Integer)paramList.get(7)).intValue() != 1) || (!StringUtil.stringValue(paramList.get(6)).equals(this.l.getUserServer())))
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
    TreeItem[] arrayOfTreeItem = this.p.getItems();
    this.i.clear();
    for (int i1 = 0; i1 < arrayOfTreeItem.length; i1++)
      a(arrayOfTreeItem[i1]);
    this.o = this.n.getSelection();
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
 * Qualified Name:     com.flagleader.builder.dialogs.g.a
 * JD-Core Version:    0.6.0
 */