package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.s;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.xml.XmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class u extends r
{
  private Envionment a = null;
  private List b = new ArrayList();
  private int c;
  private Tree d;

  public u(Shell paramShell, Envionment paramEnvionment, int paramInt)
  {
    super(paramShell);
    this.a = paramEnvionment;
    this.c = paramInt;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.LoadXmlNodeDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(550, 350));
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    localComposite1.setLayout(localGridLayout);
    this.d = new s().a(localComposite2, 67618);
    this.d.setLayoutData(new GridData(1808));
    this.d.setHeaderVisible(true);
    this.d.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.LoadXmlNodeDialog");
    while (this.d.getColumnCount() > 0)
      this.d.getColumn(0).dispose();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
      arrayOfString2[i] = ResourceTools.getMessage(arrayOfString1[i] + ".LoadXmlNodeDialog");
    for (i = 0; i < arrayOfString2.length; i++)
    {
      TreeColumn localTreeColumn = new TreeColumn(this.d, 8388608);
      localTreeColumn.setText(arrayOfString2[i]);
      if (i == 0)
        localTreeColumn.setWidth(230);
      else
        localTreeColumn.setWidth(150);
    }
    this.d.setLayoutData(new GridData(1808));
    Iterator localIterator = this.a.getXmlNodes();
    while (localIterator.hasNext())
      a((XmlNode)localIterator.next(), null);
    return localComposite1;
  }

  private void a(XmlNode paramXmlNode, TreeItem paramTreeItem)
  {
    TreeItem localTreeItem = null;
    if (paramTreeItem == null)
      localTreeItem = new TreeItem(this.d, 0);
    else
      localTreeItem = new TreeItem(paramTreeItem, 0);
    localTreeItem.setText(0, paramXmlNode.getDisplayName());
    localTreeItem.setText(1, paramXmlNode.getValueName());
    localTreeItem.setData(paramXmlNode);
    List localList = paramXmlNode.getAllNodes();
    for (int i = 0; i < localList.size(); i++)
      a((XmlNode)localList.get(i), localTreeItem);
  }

  protected void okPressed()
  {
    TreeItem[] arrayOfTreeItem = this.d.getItems();
    this.b.clear();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
    {
      if (!(arrayOfTreeItem[i].getData() instanceof XmlNode))
        continue;
      a(arrayOfTreeItem[i]);
    }
    super.okPressed();
  }

  private void a(TreeItem paramTreeItem)
  {
    TreeItem[] arrayOfTreeItem = paramTreeItem.getItems();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
    {
      if ((arrayOfTreeItem[i].getChecked()) && ((arrayOfTreeItem[i].getData() instanceof XmlNode)))
        this.b.add(arrayOfTreeItem[i].getData());
      a(arrayOfTreeItem[i]);
    }
  }

  public List a()
  {
    return this.b;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.u
 * JD-Core Version:    0.6.0
 */