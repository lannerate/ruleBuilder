package com.flagleader.builder.a.e;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.i;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.RulePackage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class k extends aS
  implements IElementViewer
{
  private Table e;
  private TableItem f;
  private TableItem g = null;
  private IRuleGroup q;
  private i r;
  private List s = new ArrayList();

  public k(IRuleGroup paramIRuleGroup, Composite paramComposite, bu parambu)
  {
    super(paramIRuleGroup, paramComposite, parambu);
    this.q = paramIRuleGroup;
  }

  protected aS e(Composite paramComposite)
  {
    return new k((IRuleGroup)this.c, paramComposite, this.a);
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "refresh");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "search");
    super.a(paramToolBar);
  }

  protected void h()
  {
    a(new p(this));
    super.h();
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    b(localComposite);
    return localComposite;
  }

  public void b(Composite paramComposite)
  {
    this.r = new i(false, true);
    this.e = this.r.a(paramComposite, 66304);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.ProjectTableView");
    String[] arrayOfString2 = ResourceTools.getStringArray("types.ProjectTableView");
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths.ProjectTableView");
    for (int i = 0; i < arrayOfString1.length; i++)
      arrayOfString1[i] = ResourceTools.getMessage(arrayOfString1[i] + ".ProjectTableView");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int j = 0; j < arrayOfString3.length; j++)
      arrayOfInt[j] = Integer.parseInt(arrayOfString3[j]);
    this.r.a(arrayOfString1, arrayOfInt, arrayOfString2);
    this.e.setLayoutData(new GridData(1808));
    this.e.setHeaderVisible(true);
    this.e.setLinesVisible(true);
    this.e.addMouseListener(new l(this));
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    this.e.removeAll();
    Iterator localIterator1 = this.q.getRulePackages();
    this.s.clear();
    int i = 1;
    while (localIterator1.hasNext())
    {
      RulePackage localRulePackage = (RulePackage)localIterator1.next();
      if (!localRulePackage.isDeveloper())
        continue;
      Iterator localIterator2 = localRulePackage.getEnvionment().getDBModels();
      while (localIterator2.hasNext())
      {
        DBModel localDBModel = (DBModel)localIterator2.next();
        Iterator localIterator3 = localDBModel.getAcceptChildren(new m(this));
        while (localIterator3.hasNext())
        {
          Object localObject1 = localIterator3.next();
          Object localObject2;
          TableItem localTableItem;
          if ((localObject1 instanceof CustomSql))
          {
            localObject2 = (CustomSql)localObject1;
            localTableItem = new TableItem(this.e, 0);
            localTableItem.setText(new String[] { i++, ((CustomSql)localObject2).getMainTableName(), ((CustomSql)localObject2).getDisplayName(), localRulePackage.getExeRulePackageName(), localRulePackage.getDisplayName(), ((CustomSql)localObject2).getSqlCustom().replace('\n', ' ').replace('\r', ' ') });
            localTableItem.setData(localObject2);
            this.s.add(localObject2);
          }
          else
          {
            if (!(localObject1 instanceof ISelectObject))
              continue;
            localObject2 = (ISelectObject)localObject1;
            localTableItem = new TableItem(this.e, 0);
            localTableItem.setText(new String[] { i++, ((ISelectObject)localObject2).getMainTableName(), ((ISelectObject)localObject2).getDisplayName(), localRulePackage.getExeRulePackageName(), localRulePackage.getDisplayName(), ((ISelectObject)localObject2).getSqlInfo() });
            localTableItem.setData(localObject2);
            this.s.add(localObject2);
          }
        }
      }
    }
    for (int j = 1; j < this.e.getColumnCount(); j++)
      this.e.getColumns()[j].pack();
    super.update();
  }

  public String getCompositeUuid()
  {
    return this.q.getEditUuid() + "table";
  }

  public boolean needUpdate()
  {
    return true;
  }

  public void find()
  {
    this.r.a();
  }

  public void findNext()
  {
    this.r.b();
  }

  public boolean isCanFind()
  {
    return true;
  }

  private void a(boolean paramBoolean)
  {
    this.p = this.e.getItemCount();
    n localn = new n(this);
    a(localn, false, true);
    C();
    localn.start();
  }

  private void a(int paramInt)
  {
    this.e.getDisplay().asyncExec(new o(this, paramInt));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.e.k
 * JD-Core Version:    0.6.0
 */