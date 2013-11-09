package com.flagleader.builder.dialogs.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.i;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class e extends r
{
  private List a = new ArrayList();
  private List b = null;
  private i c = new i(true, true);
  private BuilderManager d = null;
  private ITreeNode e;
  private Table f;
  private HashMap g = new HashMap();

  public e(Shell paramShell, List paramList, ITreeNode paramITreeNode)
  {
    super(paramShell);
    this.b = paramList;
    this.e = paramITreeNode;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.ListRuleNodeDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(860, 550));
    this.f = this.c.a(localComposite2, 67618);
    this.f.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.ListRuleNodeDialog");
    String[] arrayOfString2 = ResourceTools.getStringArray("types.ListRuleNodeDialog");
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths.ListRuleNodeDialog");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int i = 0; i < arrayOfString3.length; i++)
      arrayOfInt[i] = Integer.parseInt(arrayOfString3[i]);
    for (i = 0; i < arrayOfString1.length; i++)
      arrayOfString1[i] = a(arrayOfString1[i] + ".ListRuleTemplateDialog");
    this.c.a(arrayOfString1, arrayOfInt, arrayOfString2);
    this.f.setHeaderVisible(true);
    this.f.setLayoutData(new GridData(1808));
    a(this.e, "");
    for (i = 0; (this.b != null) && (i < this.b.size()); i++)
    {
      TableItem localTableItem = new TableItem(this.f, 0);
      List localList = (List)this.b.get(i);
      localTableItem.setData(localList);
      a(localTableItem, localList);
    }
    return localComposite1;
  }

  private void a(ITreeNode paramITreeNode, String paramString)
  {
    for (int i = 0; i < this.b.size(); i++)
    {
      List localList = (List)this.b.get(i);
      if ((paramITreeNode instanceof IRulePackage))
      {
        if ((StringUtil.stringValue(localList.get(4)).length() != 0) || (!StringUtil.stringValue(localList.get(2)).equals(paramITreeNode.getDisplayName())) || (!StringUtil.stringValue(localList.get(3)).equals(paramITreeNode.getName())))
          continue;
        localDate = (Date)localList.get(5);
        if (localDate.getTime() / 1000L < paramITreeNode.getModifyTime() / 1000L)
        {
          this.g.put(localList, "1");
          break;
        }
        if (localDate.getTime() / 1000L <= paramITreeNode.getModifyTime() / 1000L)
          break;
        this.g.put(localList, "2");
        break;
      }
      if ((!StringUtil.stringValue(localList.get(4)).equals(paramString)) || (!StringUtil.stringValue(localList.get(2)).equals(paramITreeNode.getDisplayName())) || (!StringUtil.stringValue(localList.get(3)).equals(paramITreeNode.getName())))
        continue;
      Date localDate = (Date)localList.get(5);
      if (localDate.getTime() / 1000L < paramITreeNode.getModifyTime() / 1000L)
      {
        this.g.put(localList, "1");
        break;
      }
      if (localDate.getTime() / 1000L <= paramITreeNode.getModifyTime() / 1000L)
        break;
      this.g.put(localList, "2");
      break;
    }
    Iterator localIterator = paramITreeNode.getChildNodes();
    while (localIterator.hasNext())
      a((ITreeNode)localIterator.next(), paramITreeNode.getSrcPath());
  }

  private void a(TableItem paramTableItem, List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      paramTableItem.setText(i, StringUtil.stringValue(paramList.get(i)));
      String str = (String)this.g.get(paramList);
      if ((str != null) && (str.equals("1")))
      {
        paramTableItem.setBackground(h.g);
      }
      else
      {
        if ((str == null) || (!str.equals("2")))
          continue;
        paramTableItem.setBackground(h.h);
      }
    }
  }

  protected void okPressed()
  {
    TableItem[] arrayOfTableItem = this.f.getItems();
    this.a.clear();
    for (int i = 0; i < arrayOfTableItem.length; i++)
    {
      if (!arrayOfTableItem[i].getChecked())
        continue;
      this.a.add(arrayOfTableItem[i].getData());
    }
    super.okPressed();
  }

  public List a()
  {
    return this.a;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.g.e
 * JD-Core Version:    0.6.0
 */