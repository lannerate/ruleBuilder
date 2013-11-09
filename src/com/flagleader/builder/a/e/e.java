package com.flagleader.builder.a.e;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.i;
import com.flagleader.manager.d.b;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.RulePackage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class e extends aS
  implements IElementViewer
{
  private Table e;
  private TableItem f;
  private TableItem g = null;
  private IRuleGroup q;
  private i r;

  public e(IRuleGroup paramIRuleGroup, Composite paramComposite, bu parambu)
  {
    super(paramIRuleGroup, paramComposite, parambu);
    this.q = paramIRuleGroup;
  }

  protected aS e(Composite paramComposite)
  {
    return new e((IRuleGroup)this.c, paramComposite, this.a);
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    b(localComposite);
    return localComposite;
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "rejsp");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "search");
    super.a(paramToolBar);
  }

  protected void h()
  {
    a(new g(this));
    super.h();
  }

  public void b(Composite paramComposite)
  {
    this.r = new i(false, true);
    this.e = this.r.a(paramComposite, 66304);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.ProjectJspView");
    String[] arrayOfString2 = ResourceTools.getStringArray("types.ProjectJspView");
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths.ProjectJspView");
    for (int i = 0; i < arrayOfString1.length; i++)
      arrayOfString1[i] = ResourceTools.getMessage(arrayOfString1[i] + ".ProjectJspView");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int j = 0; j < arrayOfString3.length; j++)
      arrayOfInt[j] = Integer.parseInt(arrayOfString3[j]);
    this.r.a(arrayOfString1, arrayOfInt, arrayOfString2);
    this.e.setLayoutData(new GridData(1808));
    this.e.setHeaderVisible(true);
    this.e.setLinesVisible(true);
    this.e.addMouseListener(new f(this));
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
      if (!localRulePackage.isDeveloper())
        continue;
      Iterator localIterator2 = localRulePackage.getExportModels();
      while (localIterator2.hasNext())
      {
        IPage localIPage = (IPage)localIterator2.next();
        TableItem localTableItem = new TableItem(this.e, 0);
        localTableItem.setText(new String[] { i++, localIPage.getDisplayName(), localIPage.getTitle(), localRulePackage.getExeRulePackageName(), localRulePackage.getDisplayName(), new SimpleDateFormat(b.a().i()).format(new Date(localIPage.getModifyTime())), localIPage.getExportFile() });
        localTableItem.setData(localIPage);
      }
    }
    super.update();
  }

  public String getCompositeUuid()
  {
    return this.q.getEditUuid() + "jsps";
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
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.e.e
 * JD-Core Version:    0.6.0
 */