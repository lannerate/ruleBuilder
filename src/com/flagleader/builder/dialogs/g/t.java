package com.flagleader.builder.dialogs.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.h;
import com.flagleader.engine.Property;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.ParentInfo;
import com.flagleader.util.StringUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class t extends r
{
  private List i = new ArrayList();
  private String j = "";
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
  public static final int h = 1;
  private Tree n;

  public t(BuilderManager paramBuilderManager, String paramString, ITreeNode paramITreeNode)
  {
    super(paramBuilderManager.getShell());
    this.l = paramBuilderManager;
    this.j = paramString;
    this.m = paramITreeNode;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.NodeRuleReloadDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(860, 550));
    this.n = this.k.a(localComposite2, 67618);
    this.n.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.NodeRuleReloadDialog");
    String[] arrayOfString2 = ResourceTools.getStringArray("types.NodeRuleReloadDialog");
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths.NodeRuleReloadDialog");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int i1 = 0; i1 < arrayOfString3.length; i1++)
      arrayOfInt[i1] = Integer.parseInt(arrayOfString3[i1]);
    for (i1 = 0; i1 < arrayOfString1.length; i1++)
      arrayOfString1[i1] = a(arrayOfString1[i1] + ".NodeRuleReloadDialog");
    this.k.a(arrayOfString1, arrayOfInt, arrayOfString2);
    this.n.setHeaderVisible(true);
    this.n.setLayoutData(new GridData(1808));
    this.n.addSelectionListener(new u(this));
    this.l.getShell().setCursor(this.l.getShell().getDisplay().getSystemCursor(1));
    TreeItem localTreeItem = new TreeItem(this.n, 0);
    a(localTreeItem, this.m);
    this.l.getShell().setCursor(null);
    return localComposite1;
  }

  private String a(IElement paramIElement)
  {
    if ((paramIElement instanceof IRulePackage))
      return paramIElement.getDisplayName();
    if ((paramIElement.getParent() instanceof IPackageElement))
      return a((IPackageElement)paramIElement.getParent()) + File.separator + paramIElement.getDisplayName();
    return "";
  }

  private File a(ITreeNode paramITreeNode)
  {
    String str = a(paramITreeNode.getParent());
    if (str.length() == 0)
      return new File(this.j, paramITreeNode.getDisplayName() + "." + paramITreeNode.getName());
    return new File(this.j + File.separator + str, paramITreeNode.getDisplayName() + "." + paramITreeNode.getName());
  }

  private long b(ITreeNode paramITreeNode)
  {
    File localFile = a(paramITreeNode);
    if ((localFile != null) && (localFile.exists()))
      try
      {
        ParentInfo localParentInfo = (ParentInfo)new com.flagleader.repository.e.s().load(localFile);
        return localParentInfo.getModifyTime();
      }
      catch (Exception localException)
      {
      }
    return 0L;
  }

  private void a(TreeItem paramTreeItem, ITreeNode paramITreeNode)
  {
    paramTreeItem.setText(0, paramITreeNode.getDisplayName());
    paramTreeItem.setText(1, Property.getInstance().formatDatetime(new Date(paramITreeNode.getModifyTime())));
    Image localImage = ResourceTools.getIcon(paramITreeNode);
    if (localImage != null)
      paramTreeItem.setImage(localImage);
    long l1 = b(paramITreeNode);
    if (l1 / 1000L < paramITreeNode.getModifyTime() / 1000L)
    {
      paramTreeItem.setForeground(h.h);
    }
    else if (l1 / 1000L > paramITreeNode.getModifyTime() / 1000L)
    {
      paramTreeItem.setForeground(h.g);
      paramTreeItem.setChecked(true);
    }
    paramTreeItem.setText(2, StringUtil.stringValue(new Date(l1)));
    paramTreeItem.setData(paramITreeNode);
    Iterator localIterator = paramITreeNode.getChildNodes();
    while (localIterator.hasNext())
    {
      TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
      a(localTreeItem, (ITreeNode)localIterator.next());
    }
    paramTreeItem.setExpanded(true);
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
 * Qualified Name:     com.flagleader.builder.dialogs.g.t
 * JD-Core Version:    0.6.0
 */