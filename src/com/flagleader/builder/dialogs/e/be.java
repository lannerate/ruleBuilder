package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.f;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.IElement;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.editen.ISheetFentanEditen;
import com.flagleader.repository.rlm.value.SheetFentanMapping;
import com.flagleader.repository.rlm.value.SheetFieldMapping;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.List;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class be extends f
{
  private static final int a = 450;
  private static final int b = 300;
  private TableEditor c;
  private Combo d;
  private Combo e;
  private Combo f;
  private Combo g;
  private Combo h;
  private Combo i;
  private TableItem j;
  private BuilderManager k;
  private Table l;
  private CTabFolder m;
  private List n;
  private String[] o;
  private String[] p;
  private List q;
  private ISheetFentanEditen r = null;

  public be(Shell paramShell, ISheetFentanEditen paramISheetFentanEditen, BuilderManager paramBuilderManager)
  {
    super(paramShell);
    this.r = paramISheetFentanEditen;
    this.k = paramBuilderManager;
    this.q = paramISheetFentanEditen.getCanSelectFields();
    if ((this.q != null) && (this.q.size() > 0))
    {
      this.o = new String[this.q.size()];
      for (i1 = 0; i1 < this.q.size(); i1++)
        this.o[i1] = ((IBusinessObject)this.q.get(i1)).getDisplayName();
    }
    else
    {
      this.o = new String[0];
    }
    this.n = paramISheetFentanEditen.getCanSelectSources();
    this.p = new String[this.n.size()];
    for (int i1 = 0; i1 < this.n.size(); i1++)
      this.p[i1] = ((IElement)this.n.get(i1)).getDisplayName();
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(4));
    this.d = b(localComposite2, "asheet.SelectSheetFentanDialog", 2048, 160, 12, 2);
    this.d.setItems(this.p);
    if (this.d.getItemCount() < 20)
      this.d.setVisibleItemCount(this.d.getItemCount());
    else
      this.d.setVisibleItemCount(20);
    int i1;
    if (this.r.getSourceSheet(true) != null)
      for (i1 = 0; i1 < this.n.size(); i1++)
      {
        if (!this.r.getSourceSheet(true).equals(this.n.get(i1)))
          continue;
        this.d.select(i1);
      }
    this.d.addSelectionListener(new bf(this));
    this.e = b(localComposite2, "bsheet.SelectSheetFentanDialog", 2048, 160, 12, 2);
    this.e.setItems(this.p);
    if (this.e.getItemCount() < 20)
      this.e.setVisibleItemCount(this.e.getItemCount());
    else
      this.e.setVisibleItemCount(20);
    if (this.r.getSourceSheet(false) != null)
      for (i1 = 0; i1 < this.n.size(); i1++)
      {
        if (!this.r.getSourceSheet(false).equals(this.n.get(i1)))
          continue;
        this.e.select(i1);
      }
    this.e.addSelectionListener(new bm(this));
    this.f = b(localComposite2, "afentan.SelectSheetFentanDialog", 2048, 160, 12, 2);
    this.f.addSelectionListener(new bn(this));
    a(this.r.getCanSelectSourceFields(true));
    this.h = b(localComposite2, "byingzi.SelectSheetFentanDialog", 2048, 160, 12, 2);
    this.h.addSelectionListener(new bo(this));
    c(this.r.getCanSelectSourceFields(false));
    this.g = b(localComposite2, "cfentan.SelectSheetFentanDialog", 2048, 160, 12, 2);
    this.g.addSelectionListener(new bp(this));
    b(this.r.getCanSelectFields());
    this.i = b(localComposite2, "cyingzi.SelectSheetFentanDialog", 2048, 160, 12, 2);
    this.i.addSelectionListener(new bq(this));
    d(this.r.getCanSelectFields());
    this.m = new CTabFolder(localComposite1, 0);
    this.m.setLayoutData(a(490, 340));
    this.m.setLayout(new GridLayout());
    CTabItem localCTabItem = new CTabItem(this.m, 0);
    localCTabItem.setText(b("afields.SelectSheetFentanDialog"));
    Composite localComposite3 = new Composite(this.m, 0);
    localComposite3.setLayout(new GridLayout());
    localComposite3.setLayoutData(new GridData(1808));
    Table localTable1 = c(localComposite3, 0);
    a(true);
    localCTabItem.setControl(localComposite3);
    localCTabItem = new CTabItem(this.m, 0);
    localCTabItem.setText(b("bfields.SelectSheetFentanDialog"));
    localComposite3 = new Composite(this.m, 0);
    localComposite3.setLayout(new GridLayout());
    localComposite3.setLayoutData(new GridData(1808));
    Table localTable2 = c(localComposite3, 1);
    a(false);
    localCTabItem.setControl(localComposite3);
    localCTabItem = new CTabItem(this.m, 0);
    localCTabItem.setText(b("cfields.SelectSheetFentanDialog"));
    localComposite3 = new Composite(this.m, 0);
    localComposite3.setLayout(new GridLayout());
    localComposite3.setLayoutData(new GridData(1808));
    Table localTable3 = c(localComposite3, 2);
    a(localTable3, this.r.getSelectedConditions());
    localCTabItem.setControl(localComposite3);
    this.m.addSelectionListener(new br(this, localTable1, localTable2, localTable3));
    Composite localComposite4 = new Composite(localComposite1, 0);
    localComposite4.setLayoutData(new GridData(1808));
    localComposite4.setLayout(a(7));
    d(localComposite4);
    b(localComposite1);
    this.m.setSelection(0);
    this.l = localTable1;
    return localComposite1;
  }

  private void a(Combo paramCombo, String[] paramArrayOfString)
  {
    paramCombo.setItems(paramArrayOfString);
    if (paramCombo.getItemCount() < 20)
      paramCombo.setVisibleItemCount(paramCombo.getItemCount());
    else
      paramCombo.setVisibleItemCount(20);
  }

  private void a(List paramList)
  {
    String[] arrayOfString = new String[paramList.size()];
    for (int i1 = 0; i1 < paramList.size(); i1++)
      arrayOfString[i1] = ((IBusinessObject)paramList.get(i1)).getDisplayName();
    a(this.f, arrayOfString);
    if (this.r.getSourceField(0) != null)
      for (i1 = 0; i1 < paramList.size(); i1++)
      {
        if (!paramList.get(i1).equals(this.r.getSourceField(0)))
          continue;
        this.f.select(i1);
      }
  }

  private void b(List paramList)
  {
    String[] arrayOfString = new String[paramList.size()];
    for (int i1 = 0; i1 < paramList.size(); i1++)
      arrayOfString[i1] = ((IBusinessObject)paramList.get(i1)).getDisplayName();
    a(this.g, arrayOfString);
    if (this.r.getSourceField(1) != null)
      for (i1 = 0; i1 < paramList.size(); i1++)
      {
        if (!paramList.get(i1).equals(this.r.getSourceField(1)))
          continue;
        this.g.select(i1);
      }
  }

  private void c(List paramList)
  {
    if (paramList == null)
      return;
    String[] arrayOfString = new String[paramList.size()];
    for (int i1 = 0; i1 < paramList.size(); i1++)
      arrayOfString[i1] = ((IBusinessObject)paramList.get(i1)).getDisplayName();
    a(this.h, arrayOfString);
    if (this.r.getSourceField(2) != null)
      for (i1 = 0; i1 < paramList.size(); i1++)
      {
        if (!paramList.get(i1).equals(this.r.getSourceField(2)))
          continue;
        this.h.select(i1);
      }
  }

  private void d(List paramList)
  {
    String[] arrayOfString = new String[paramList.size()];
    for (int i1 = 0; i1 < paramList.size(); i1++)
      arrayOfString[i1] = ((IBusinessObject)paramList.get(i1)).getDisplayName();
    a(this.i, arrayOfString);
    if (this.r.getSourceField(3) != null)
      for (i1 = 0; i1 < paramList.size(); i1++)
      {
        if (!paramList.get(i1).equals(this.r.getSourceField(3)))
          continue;
        this.i.select(i1);
      }
  }

  private boolean g()
  {
    return this.m.getSelectionIndex() == 1;
  }

  private Table c(Composite paramComposite, int paramInt)
  {
    this.l = e(paramComposite);
    a(this.l, paramInt);
    this.c = new TableEditor(this.l);
    this.l.addMouseMoveListener(new bs(this));
    this.l.addMouseListener(new bt(this));
    return this.l;
  }

  private void h()
  {
    Object localObject1;
    Object localObject2;
    TableItem localTableItem;
    IBusinessObject localIBusinessObject;
    if (this.m.getSelectionIndex() == 0)
    {
      localObject1 = new bu(this, true);
      if ((((bu)localObject1).open() == 0) && (((bu)localObject1).c() >= 0))
      {
        localObject2 = new SheetFieldMapping(((bu)localObject1).b(), (IBusinessObject)this.q.get(((bu)localObject1).a()));
        this.r.addChildElement((IElement)localObject2);
        localTableItem = new TableItem(this.l, 0);
        localIBusinessObject = (IBusinessObject)this.q.get(((bu)localObject1).a());
        localTableItem.setText(0, ((bu)localObject1).b().getDisplayName() + "-" + ((bu)localObject1).b().getValueName() + "-" + ((bu)localObject1).b().getValueType());
        localTableItem.setText(1, localIBusinessObject.getDisplayName());
        localTableItem.setText(2, localIBusinessObject.getValueType());
        localTableItem.setText(3, localIBusinessObject.getValueName());
        localTableItem.setData(localObject2);
        this.r.getRoot().setModified(true);
        this.r.update();
      }
    }
    else if (this.m.getSelectionIndex() == 1)
    {
      localObject1 = new bu(this, false);
      if ((((bu)localObject1).open() == 0) && (((bu)localObject1).c() >= 0))
      {
        localObject2 = new SheetFieldMapping(((bu)localObject1).b(), (IBusinessObject)this.q.get(((bu)localObject1).a()));
        this.r.addChildElement((IElement)localObject2);
        localTableItem = new TableItem(this.l, 0);
        localIBusinessObject = (IBusinessObject)this.q.get(((bu)localObject1).a());
        localTableItem.setText(0, ((bu)localObject1).b().getDisplayName() + "-" + ((bu)localObject1).b().getValueName() + "-" + ((bu)localObject1).b().getValueType());
        localTableItem.setText(1, localIBusinessObject.getDisplayName());
        localTableItem.setText(2, localIBusinessObject.getValueType());
        localTableItem.setText(3, localIBusinessObject.getValueName());
        localTableItem.setData(localObject2);
        this.r.getRoot().setModified(true);
        this.r.update();
      }
    }
    else if (this.m.getSelectionIndex() == 2)
    {
      localObject1 = new bx(this);
      if ((((bx)localObject1).open() == 0) && (((bx)localObject1).c() >= 0))
      {
        localObject2 = new SheetFentanMapping(((bx)localObject1).b(), ((bx)localObject1).d(), (IBusinessObject)this.q.get(((bx)localObject1).a()));
        this.r.addChildElement((IElement)localObject2);
        localTableItem = new TableItem(this.l, 0);
        localTableItem.setText(0, ((SheetFentanMapping)localObject2).getField().getShowDisplayName());
        localTableItem.setText(1, ((SheetFentanMapping)localObject2).getBField().getShowDisplayName());
        localTableItem.setText(2, ((IBusinessObject)this.q.get(((bx)localObject1).a())).getShowDisplayName());
        localTableItem.setData(localObject2);
        this.r.getRoot().setModified(true);
        this.r.update();
      }
    }
  }

  private void i()
  {
    Object localObject;
    int i1;
    int i5;
    SheetFieldMapping localSheetFieldMapping;
    if (this.m.getSelectionIndex() == 0)
    {
      localObject = (SheetFieldMapping)j().getData();
      i1 = -1;
      for (int i2 = 0; i2 < this.q.size(); i2++)
      {
        if (!this.q.get(i2).equals(((SheetFieldMapping)localObject).getField()))
          continue;
        i1 = i2;
        break;
      }
      List localList1 = this.r.getCanSelectSourceFields(true);
      i5 = -1;
      for (int i6 = 0; i6 < localList1.size(); i6++)
      {
        if (!localList1.get(i6).equals(((SheetFieldMapping)localObject).getMappingField()))
          continue;
        i5 = i6;
        break;
      }
      bu localbu1 = new bu(this, i5, i1, true);
      if ((localbu1.open() == 0) && ((i5 != localbu1.c()) || (i1 != localbu1.a())))
      {
        localSheetFieldMapping = (SheetFieldMapping)j().getData();
        localSheetFieldMapping.setMappingField(localbu1.b());
        localSheetFieldMapping.setField((IBusinessObject)this.q.get(localbu1.a()));
        j().setText(0, localbu1.b().getDisplayName() + "-" + localbu1.b().getValueName() + "-" + localbu1.b().getValueType());
        j().setText(1, localSheetFieldMapping.getField().getDisplayName());
        j().setText(2, localSheetFieldMapping.getField().getValueType());
        j().setText(3, localSheetFieldMapping.getField().getValueName());
        this.r.getRoot().setModified(true);
        this.r.update();
      }
    }
    else if (this.m.getSelectionIndex() == 1)
    {
      localObject = (SheetFieldMapping)j().getData();
      i1 = -1;
      for (int i3 = 0; i3 < this.q.size(); i3++)
      {
        if (!this.q.get(i3).equals(((SheetFieldMapping)localObject).getField()))
          continue;
        i1 = i3;
        break;
      }
      List localList2 = this.r.getCanSelectSourceFields(false);
      i5 = -1;
      for (int i7 = 0; i7 < localList2.size(); i7++)
      {
        if (!localList2.get(i7).equals(((SheetFieldMapping)localObject).getMappingField()))
          continue;
        i5 = i7;
        break;
      }
      bu localbu2 = new bu(this, i5, i1, false);
      if ((localbu2.open() == 0) && ((i5 != localbu2.c()) || (i1 != localbu2.a())))
      {
        localSheetFieldMapping = (SheetFieldMapping)j().getData();
        localSheetFieldMapping.setMappingField(localbu2.b());
        localSheetFieldMapping.setField((IBusinessObject)this.q.get(localbu2.a()));
        j().setText(0, localbu2.b().getDisplayName() + "-" + localbu2.b().getValueName() + "-" + localbu2.b().getValueType());
        j().setText(1, localSheetFieldMapping.getField().getDisplayName());
        j().setText(2, localSheetFieldMapping.getField().getValueType());
        j().setText(3, localSheetFieldMapping.getField().getValueName());
        this.r.getRoot().setModified(true);
        this.r.update();
      }
    }
    else if (this.m.getSelectionIndex() == 2)
    {
      localObject = (SheetFentanMapping)j().getData();
      i1 = -1;
      for (int i4 = 0; i4 < this.q.size(); i4++)
      {
        if (!this.q.get(i4).equals(((SheetFentanMapping)localObject).getMappingField()))
          continue;
        i1 = i4;
        break;
      }
      List localList3 = this.r.getCanSelectSourceFields(true);
      i5 = -1;
      for (int i8 = 0; i8 < localList3.size(); i8++)
      {
        if (!localList3.get(i8).equals(((SheetFentanMapping)localObject).getField()))
          continue;
        i5 = i8;
        break;
      }
      List localList4 = this.r.getCanSelectSourceFields(false);
      int i9 = -1;
      for (int i10 = 0; i10 < localList4.size(); i10++)
      {
        if (!localList4.get(i10).equals(((SheetFentanMapping)localObject).getBField()))
          continue;
        i9 = i10;
        break;
      }
      bx localbx = new bx(this, i5, i9, i1);
      if ((localbx.open() == 0) && ((i5 != localbx.c()) || (i1 != localbx.a()) || (i9 != localbx.e())))
      {
        SheetFentanMapping localSheetFentanMapping = (SheetFentanMapping)j().getData();
        localSheetFentanMapping.setMappingField((IBusinessObject)this.q.get(localbx.a()));
        localSheetFentanMapping.setField(localbx.b());
        localSheetFentanMapping.setBField(localbx.d());
        j().setText(0, localSheetFentanMapping.getField().getShowDisplayName());
        j().setText(1, localSheetFentanMapping.getBField().getShowDisplayName());
        j().setText(2, ((IBusinessObject)this.q.get(localbx.a())).getShowDisplayName());
        this.r.getRoot().setModified(true);
        this.r.update();
      }
    }
  }

  private void d(Composite paramComposite)
  {
    Button localButton1 = f(paramComposite);
    localButton1.setText(b("add.DataDialog"));
    localButton1.addSelectionListener(new bg(this));
    Button localButton2 = f(paramComposite);
    localButton2.setText(b("edit.DataDialog"));
    localButton2.addSelectionListener(new bh(this));
    Button localButton3 = f(paramComposite);
    localButton3.setText(b("delete.DataDialog"));
    localButton3.addSelectionListener(new bi(this));
    localButton1 = f(paramComposite);
    localButton1.setText(ResourceTools.getMessage("moveUp.DataDialog"));
    localButton1.addSelectionListener(new bj(this));
    Button localButton4 = f(paramComposite);
    localButton4.setText(b("moveDown.DataDialog"));
    localButton4.addSelectionListener(new bk(this));
    localButton2 = f(paramComposite);
    localButton2.setText(b("reset.DataDialog"));
    localButton2.addSelectionListener(new bl(this));
  }

  private Table e(Composite paramComposite)
  {
    Table localTable = new Table(paramComposite, 68354);
    GridData localGridData = new GridData();
    localGridData.widthHint = 450;
    localGridData.heightHint = 300;
    localTable.setLayoutData(localGridData);
    localTable.setLinesVisible(true);
    return localTable;
  }

  private void a(Table paramTable, List paramList)
  {
    if (paramList != null)
      for (int i1 = 0; i1 < paramList.size(); i1++)
      {
        TableItem localTableItem = new TableItem(paramTable, 0);
        SheetFentanMapping localSheetFentanMapping = (SheetFentanMapping)paramList.get(i1);
        IBusinessObject localIBusinessObject1 = localSheetFentanMapping.getField();
        IBusinessObject localIBusinessObject2 = localSheetFentanMapping.getBField();
        IBusinessObject localIBusinessObject3 = localSheetFentanMapping.getMappingField();
        if ((localIBusinessObject2 != null) && (localIBusinessObject2 != null) && (localIBusinessObject3 != null))
        {
          localTableItem.setText(new String[] { localIBusinessObject1.getShowDisplayName(), localIBusinessObject2.getShowDisplayName(), localIBusinessObject3.getShowDisplayName() });
          if (!localIBusinessObject1.getParent().equals(this.r.getSourceSheet(true)))
            localTableItem.setBackground(h.g);
          if (!localIBusinessObject2.getParent().equals(this.r.getSourceSheet(false)))
            localTableItem.setBackground(h.g);
        }
        else
        {
          localTableItem.setText(new String[] { b("notExits.TEXT"), "", "" });
          localTableItem.setBackground(h.g);
        }
        localTableItem.setData(localSheetFentanMapping);
      }
  }

  private void a(boolean paramBoolean)
  {
    this.l.removeAll();
    Control[] arrayOfControl = this.l.getChildren();
    for (int i1 = 0; i1 < arrayOfControl.length; i1++)
      arrayOfControl[i1].dispose();
    List localList = this.r.getSelectedFields(paramBoolean);
    if (localList != null)
      for (int i2 = 0; i2 < localList.size(); i2++)
      {
        TableItem localTableItem = new TableItem(this.l, 0);
        SheetFieldMapping localSheetFieldMapping = (SheetFieldMapping)localList.get(i2);
        IBusinessObject localIBusinessObject1 = localSheetFieldMapping.getField();
        IBusinessObject localIBusinessObject2 = localSheetFieldMapping.getMappingField();
        String str = null;
        if (localIBusinessObject2 != null)
        {
          str = localIBusinessObject2.getDisplayName() + "-" + localIBusinessObject2.getValueName() + "-" + localIBusinessObject2.getValueType();
        }
        else
        {
          str = b("notExits.TEXT");
          localTableItem.setBackground(h.g);
        }
        if ((localIBusinessObject1 != null) && (localIBusinessObject2 != null))
        {
          localTableItem.setText(new String[] { str, localIBusinessObject1.getDisplayName(), localIBusinessObject1.getValueType(), localIBusinessObject1.getValueName() });
          if (!localIBusinessObject1.getJavaType().a(localIBusinessObject2.getJavaType()))
            localTableItem.setBackground(h.g);
          else if (!localIBusinessObject2.getParent().equals(this.r.getSourceSheet(paramBoolean)))
            localTableItem.setBackground(h.g);
          else if (!localIBusinessObject1.getDisplayName().equalsIgnoreCase(localIBusinessObject2.getDisplayName()))
            localTableItem.setBackground(h.h);
        }
        else
        {
          localTableItem.setText(new String[] { str, b("notExits.TEXT"), "", "" });
          localTableItem.setBackground(h.g);
        }
        localTableItem.setData(localSheetFieldMapping);
      }
  }

  private void a(Table paramTable, int paramInt)
  {
    paramTable.setLinesVisible(true);
    paramTable.setHeaderVisible(true);
    TableColumn localTableColumn;
    if (paramInt == 0)
    {
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("mappingfield.SelectSheetAndFieldsDialog"));
      localTableColumn.setWidth(150);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("field.SelectSheetAndFieldsDialog"));
      localTableColumn.setWidth(145);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("fieldtype.SelectSheetAndFieldsDialog"));
      localTableColumn.setWidth(85);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("fieldname.SelectSheetAndFieldsDialog"));
      localTableColumn.setWidth(65);
    }
    else if (paramInt == 1)
    {
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("mappingfield.SelectSheetAndFieldsDialog"));
      localTableColumn.setWidth(150);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("field.SelectSheetAndFieldsDialog"));
      localTableColumn.setWidth(145);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("fieldtype.SelectSheetAndFieldsDialog"));
      localTableColumn.setWidth(85);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("fieldname.SelectSheetAndFieldsDialog"));
      localTableColumn.setWidth(65);
    }
    else if (paramInt == 2)
    {
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("afield.SelectSheetFentanDialog"));
      localTableColumn.setWidth(150);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("bfield.SelectSheetFentanDialog"));
      localTableColumn.setWidth(145);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("cfield.SelectSheetFentanDialog"));
      localTableColumn.setWidth(150);
    }
  }

  private TableItem j()
  {
    if (this.l.getSelectionIndex() >= 0)
      return this.l.getSelection()[0];
    return null;
  }

  private Button f(Composite paramComposite)
  {
    Button localButton = new Button(paramComposite, 8);
    GridData localGridData = new GridData();
    localGridData.widthHint = 65;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.horizontalIndent = 16;
    localButton.setLayoutData(localGridData);
    return localButton;
  }

  protected void okPressed()
  {
    this.r.update();
    close();
  }

  protected void a()
  {
    close();
  }

  public boolean b()
  {
    return false;
  }

  public boolean c()
  {
    return false;
  }

  public boolean d()
  {
    return this.l.getSelectionCount() > 0;
  }

  public boolean e()
  {
    return false;
  }

  public void f()
  {
    TableItem[] arrayOfTableItem = this.l.getSelection();
    for (int i1 = 0; i1 < arrayOfTableItem.length; i1++)
    {
      ((IElement)arrayOfTableItem[i1].getData()).dispose();
      arrayOfTableItem[i1].dispose();
    }
    this.r.getRoot().setModified(true);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.be
 * JD-Core Version:    0.6.0
 */