package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.s;
import com.flagleader.repository.tree.IRuleTree;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class a extends r
{
  private List a = null;
  private List b = new ArrayList();
  private s c = new s();
  private Tree d;

  public a(Shell paramShell, List paramList)
  {
    super(paramShell);
    this.a = paramList;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.AddRuleMirrorDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(500, 350));
    this.d = this.c.a(localComposite2, 67618);
    this.d.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.AddRuleMirrorDialog");
    while (this.d.getColumnCount() > 0)
      this.d.getColumn(0).dispose();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    int[] arrayOfInt = new int[arrayOfString1.length];
    String[] arrayOfString3 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      arrayOfString2[i] = ResourceTools.getMessage(arrayOfString1[i] + ".AddRuleMirrorDialog");
      arrayOfInt[i] = 250;
      arrayOfString3[i] = "string";
    }
    this.c.a(arrayOfString2, arrayOfInt, arrayOfString3);
    this.d.setHeaderVisible(true);
    this.d.setLayoutData(new GridData(1808));
    for (i = 0; i < this.a.size(); i++)
    {
      TreeItem localTreeItem = new TreeItem(this.d, 0);
      IRuleTree localIRuleTree = (IRuleTree)this.a.get(i);
      localTreeItem.setData(localIRuleTree);
      a(localTreeItem, localIRuleTree.getDisplayName());
    }
    for (i = 0; i < this.d.getColumnCount(); i++)
      this.d.getColumn(i).pack();
    return localComposite1;
  }

  private void a(TreeItem paramTreeItem, String paramString)
  {
    paramTreeItem.setText(0, paramString);
  }

  protected void okPressed()
  {
    TreeItem[] arrayOfTreeItem = this.d.getItems();
    this.b.clear();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
    {
      if (!arrayOfTreeItem[i].getChecked())
        continue;
      this.b.add(arrayOfTreeItem[i].getData());
    }
    super.okPressed();
  }

  public List a()
  {
    return this.b;
  }

  public List b()
  {
    ArrayList localArrayList = new ArrayList(this.a.size() - this.b.size());
    localArrayList.addAll(this.a);
    localArrayList.removeAll(this.b);
    return localArrayList;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.a
 * JD-Core Version:    0.6.0
 */