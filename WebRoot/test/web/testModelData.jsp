<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'test.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body onload="test()">
	This is my JSP page.
	<br>
</body>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/web/script/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/web/script/json2.js"></script>


<script type="text/javascript">  
/*     function modelrow(sequence,name,feeType,children){  
        this.sequence=sequence;  
        this.name=name;  
        this.feeType=feeType;  
        this.children=children;  
    }  
    
    
    var mr1 = new Array(); 
    
    var mr2 = new Array(); 
    mr2[0] = new modelrow("1.1.1.1","�����豸�ѷ�",1,null);
    mr2[1] = new modelrow("1.1.1.2","�����豸��",1,null);
    mr2[2] = new modelrow("1.1.1.3","�豸���������޷�",1,null);
    
    mr1[0] = new modelrow("1.1.1","�豸��",1,mr2);
    
    mr1[1] = new modelrow("1.1.2","���Ϸ�",1,null);
    mr1[2] = new modelrow("1.1.3","���Ի���ӹ���",1,null);
  
    var root = new modelrow("1.1","ֱ�ӷ���",1,mr1);  
             
              
                
    var jsonModel= $.parseJSON(root);
  
    alert( jsonModel); */
    
    var root = {
        "project_id": 2,
        "id": 57,
        "fid": 0,
        "sequence": "1.1",
        "name": "ֱ�ӷ�yong",
        "feeType": 1,
        "data": {
            "id": null,
            "name": null,
            "sequence": "1.1",
            "branch_id": null,
            "calBasis": null,
            "isBranch": 0,
            "designT": null,
            "realT": null,
            "mainSetT": null,
            "childSetT": null,
            "isLockT": null,
            "isLockA": null,
            "isLockB": null,
            "designA": null,
            "realA": null,
            "mainSetA": null,
            "childSetA": null,
            "designB": null,
            "realB": null,
            "mainSetB": null,
            "childSetB": null
        },
        "subDatas": [
            {
                "id": null,
                "name": "����",
                "sequence": "1.1",
                "branch_id": 2,
                "calBasis": null,
                "isBranch": 1,
                "designT": null,
                "realT": null,
                "mainSetT": null,
                "childSetT": null,
                "isLockT": null,
                "isLockA": null,
                "isLockB": null,
                "designA": null,
                "realA": null,
                "mainSetA": null,
                "childSetA": null,
                "designB": null,
                "realB": null,
                "mainSetB": null,
                "childSetB": null
            },
            {
                "id": null,
                "name": "��ʦ��",
                "sequence": "1.1",
                "branch_id": 1,
                "calBasis": null,
                "isBranch": 1,
                "designT": null,
                "realT": null,
                "mainSetT": null,
                "childSetT": null,
                "isLockT": null,
                "isLockA": null,
                "isLockB": null,
                "designA": null,
                "realA": null,
                "mainSetA": null,
                "childSetA": null,
                "designB": null,
                "realB": null,
                "mainSetB": null,
                "childSetB": null
            }
        ],
        "children": [
            {
                "project_id": 2,
                "id": 58,
                "fid": 57,
                "sequence": "1.1.1",
                "name": "�豸��",
                "feeType": 2,
                "data": {
                    "id": null,
                    "name": null,
                    "sequence": "1.1.1",
                    "branch_id": null,
                    "calBasis": null,
                    "isBranch": 0,
                    "designT": null,
                    "realT": null,
                    "mainSetT": null,
                    "childSetT": null,
                    "isLockT": null,
                    "isLockA": null,
                    "isLockB": null,
                    "designA": null,
                    "realA": null,
                    "mainSetA": null,
                    "childSetA": null,
                    "designB": null,
                    "realB": null,
                    "mainSetB": null,
                    "childSetB": null
                },
                "subDatas": [
                    {
                        "id": null,
                        "name": "����",
                        "sequence": "1.1.1",
                        "branch_id": 2,
                        "calBasis": null,
                        "isBranch": 1,
                        "designT": null,
                        "realT": null,
                        "mainSetT": null,
                        "childSetT": null,
                        "isLockT": null,
                        "isLockA": null,
                        "isLockB": null,
                        "designA": null,
                        "realA": null,
                        "mainSetA": null,
                        "childSetA": null,
                        "designB": null,
                        "realB": null,
                        "mainSetB": null,
                        "childSetB": null
                    },
                    {
                        "id": null,
                        "name": "��ʦ��",
                        "sequence": "1.1.1",
                        "branch_id": 1,
                        "calBasis": null,
                        "isBranch": 1,
                        "designT": null,
                        "realT": null,
                        "mainSetT": null,
                        "childSetT": null,
                        "isLockT": null,
                        "isLockA": null,
                        "isLockB": null,
                        "designA": null,
                        "realA": null,
                        "mainSetA": null,
                        "childSetA": null,
                        "designB": null,
                        "realB": null,
                        "mainSetB": null,
                        "childSetB": null
                    }
                ],
                "children": [
                    {
                        "project_id": 2,
                        "id": 59,
                        "fid": 58,
                        "sequence": "1.1.1.1",
                        "name": "�����豸�ѷ�",
                        "feeType": 2,
                        "data": {
                            "id": null,
                            "name": null,
                            "sequence": "1.1.1.1",
                            "branch_id": null,
                            "calBasis": null,
                            "isBranch": 0,
                            "designT": null,
                            "realT": null,
                            "mainSetT": null,
                            "childSetT": null,
                            "isLockT": null,
                            "isLockA": null,
                            "isLockB": null,
                            "designA": null,
                            "realA": null,
                            "mainSetA": null,
                            "childSetA": null,
                            "designB": null,
                            "realB": null,
                            "mainSetB": null,
                            "childSetB": null
                        },
                        "subDatas": [
                            {
                                "id": null,
                                "name": "����",
                                "sequence": "1.1.1.1",
                                "branch_id": 2,
                                "calBasis": null,
                                "isBranch": 1,
                                "designT": null,
                                "realT": null,
                                "mainSetT": null,
                                "childSetT": null,
                                "isLockT": null,
                                "isLockA": null,
                                "isLockB": null,
                                "designA": null,
                                "realA": null,
                                "mainSetA": null,
                                "childSetA": null,
                                "designB": null,
                                "realB": null,
                                "mainSetB": null,
                                "childSetB": null
                            },
                            {
                                "id": null,
                                "name": "��ʦ��",
                                "sequence": "1.1.1.1",
                                "branch_id": 1,
                                "calBasis": null,
                                "isBranch": 1,
                                "designT": null,
                                "realT": null,
                                "mainSetT": null,
                                "childSetT": null,
                                "isLockT": null,
                                "isLockA": null,
                                "isLockB": null,
                                "designA": null,
                                "realA": null,
                                "mainSetA": null,
                                "childSetA": null,
                                "designB": null,
                                "realB": null,
                                "mainSetB": null,
                                "childSetB": null
                            }
                        ],
                        "children": [
                            
                        ]
                    },
                    {
                        "project_id": 2,
                        "id": 60,
                        "fid": 58,
                        "sequence": "1.1.1.2",
                        "name": "�����豸��",
                        "feeType": 2,
                        "data": {
                            "id": null,
                            "name": null,
                            "sequence": "1.1.1.2",
                            "branch_id": null,
                            "calBasis": null,
                            "isBranch": 0,
                            "designT": null,
                            "realT": null,
                            "mainSetT": null,
                            "childSetT": null,
                            "isLockT": null,
                            "isLockA": null,
                            "isLockB": null,
                            "designA": null,
                            "realA": null,
                            "mainSetA": null,
                            "childSetA": null,
                            "designB": null,
                            "realB": null,
                            "mainSetB": null,
                            "childSetB": null
                        },
                        "subDatas": [
                            {
                                "id": null,
                                "name": "����",
                                "sequence": "1.1.1.2",
                                "branch_id": 2,
                                "calBasis": null,
                                "isBranch": 1,
                                "designT": null,
                                "realT": null,
                                "mainSetT": null,
                                "childSetT": null,
                                "isLockT": null,
                                "isLockA": null,
                                "isLockB": null,
                                "designA": null,
                                "realA": null,
                                "mainSetA": null,
                                "childSetA": null,
                                "designB": null,
                                "realB": null,
                                "mainSetB": null,
                                "childSetB": null
                            },
                            {
                                "id": null,
                                "name": "��ʦ��",
                                "sequence": "1.1.1.2",
                                "branch_id": 1,
                                "calBasis": null,
                                "isBranch": 1,
                                "designT": null,
                                "realT": null,
                                "mainSetT": null,
                                "childSetT": null,
                                "isLockT": null,
                                "isLockA": null,
                                "isLockB": null,
                                "designA": null,
                                "realA": null,
                                "mainSetA": null,
                                "childSetA": null,
                                "designB": null,
                                "realB": null,
                                "mainSetB": null,
                                "childSetB": null
                            }
                        ],
                        "children": [
                            
                        ]
                    },
                    {
                        "project_id": 2,
                        "id": 61,
                        "fid": 58,
                        "sequence": "1.1.1.3",
                        "name": "�豸���������޷�",
                        "feeType": 2,
                        "data": {
                            "id": null,
                            "name": null,
                            "sequence": "1.1.1.3",
                            "branch_id": null,
                            "calBasis": null,
                            "isBranch": 0,
                            "designT": null,
                            "realT": null,
                            "mainSetT": null,
                            "childSetT": null,
                            "isLockT": null,
                            "isLockA": null,
                            "isLockB": null,
                            "designA": null,
                            "realA": null,
                            "mainSetA": null,
                            "childSetA": null,
                            "designB": null,
                            "realB": null,
                            "mainSetB": null,
                            "childSetB": null
                        },
                        "subDatas": [
                            {
                                "id": null,
                                "name": "����",
                                "sequence": "1.1.1.3",
                                "branch_id": 2,
                                "calBasis": null,
                                "isBranch": 1,
                                "designT": null,
                                "realT": null,
                                "mainSetT": null,
                                "childSetT": null,
                                "isLockT": null,
                                "isLockA": null,
                                "isLockB": null,
                                "designA": null,
                                "realA": null,
                                "mainSetA": null,
                                "childSetA": null,
                                "designB": null,
                                "realB": null,
                                "mainSetB": null,
                                "childSetB": null
                            },
                            {
                                "id": null,
                                "name": "��ʦ��",
                                "sequence": "1.1.1.3",
                                "branch_id": 1,
                                "calBasis": null,
                                "isBranch": 1,
                                "designT": null,
                                "realT": null,
                                "mainSetT": null,
                                "childSetT": null,
                                "isLockT": null,
                                "isLockA": null,
                                "isLockB": null,
                                "designA": null,
                                "realA": null,
                                "mainSetA": null,
                                "childSetA": null,
                                "designB": null,
                                "realB": null,
                                "mainSetB": null,
                                "childSetB": null
                            }
                        ],
                        "children": [
                            
                        ]
                    }
                ]
            },
            {
                "project_id": 2,
                "id": 62,
                "fid": 57,
                "sequence": "1.1.2",
                "name": "���Ϸ�",
                "feeType": 3,
                "data": {
                    "id": null,
                    "name": null,
                    "sequence": "1.1.2",
                    "branch_id": null,
                    "calBasis": null,
                    "isBranch": 0,
                    "designT": null,
                    "realT": null,
                    "mainSetT": null,
                    "childSetT": null,
                    "isLockT": null,
                    "isLockA": null,
                    "isLockB": null,
                    "designA": null,
                    "realA": null,
                    "mainSetA": null,
                    "childSetA": null,
                    "designB": null,
                    "realB": null,
                    "mainSetB": null,
                    "childSetB": null
                },
                "subDatas": [
                    {
                        "id": null,
                        "name": "����",
                        "sequence": "1.1.2",
                        "branch_id": 2,
                        "calBasis": null,
                        "isBranch": 1,
                        "designT": null,
                        "realT": null,
                        "mainSetT": null,
                        "childSetT": null,
                        "isLockT": null,
                        "isLockA": null,
                        "isLockB": null,
                        "designA": null,
                        "realA": null,
                        "mainSetA": null,
                        "childSetA": null,
                        "designB": null,
                        "realB": null,
                        "mainSetB": null,
                        "childSetB": null
                    },
                    {
                        "id": null,
                        "name": "��ʦ��",
                        "sequence": "1.1.2",
                        "branch_id": 1,
                        "calBasis": null,
                        "isBranch": 1,
                        "designT": null,
                        "realT": null,
                        "mainSetT": null,
                        "childSetT": null,
                        "isLockT": null,
                        "isLockA": null,
                        "isLockB": null,
                        "designA": null,
                        "realA": null,
                        "mainSetA": null,
                        "childSetA": null,
                        "designB": null,
                        "realB": null,
                        "mainSetB": null,
                        "childSetB": null
                    }
                ],
                "children": [
                    
                ]
            },
            {
                "project_id": 2,
                "id": 63,
                "fid": 57,
                "sequence": "1.1.3",
                "name": "���Ի���ӹ���",
                "feeType": 4,
                "data": {
                    "id": null,
                    "name": null,
                    "sequence": "1.1.3",
                    "branch_id": null,
                    "calBasis": null,
                    "isBranch": 0,
                    "designT": null,
                    "realT": null,
                    "mainSetT": null,
                    "childSetT": null,
                    "isLockT": null,
                    "isLockA": null,
                    "isLockB": null,
                    "designA": null,
                    "realA": null,
                    "mainSetA": null,
                    "childSetA": null,
                    "designB": null,
                    "realB": null,
                    "mainSetB": null,
                    "childSetB": null
                },
                "subDatas": [
                    {
                        "id": null,
                        "name": "����",
                        "sequence": "1.1.3",
                        "branch_id": 2,
                        "calBasis": null,
                        "isBranch": 1,
                        "designT": null,
                        "realT": null,
                        "mainSetT": null,
                        "childSetT": null,
                        "isLockT": null,
                        "isLockA": null,
                        "isLockB": null,
                        "designA": null,
                        "realA": null,
                        "mainSetA": null,
                        "childSetA": null,
                        "designB": null,
                        "realB": null,
                        "mainSetB": null,
                        "childSetB": null
                    },
                    {
                        "id": null,
                        "name": "��ʦ��",
                        "sequence": "1.1.3",
                        "branch_id": 1,
                        "calBasis": null,
                        "isBranch": 1,
                        "designT": null,
                        "realT": null,
                        "mainSetT": null,
                        "childSetT": null,
                        "isLockT": null,
                        "isLockA": null,
                        "isLockB": null,
                        "designA": null,
                        "realA": null,
                        "mainSetA": null,
                        "childSetA": null,
                        "designB": null,
                        "realB": null,
                        "mainSetB": null,
                        "childSetB": null
                    }
                ],
                "children": [
                    
                ]
            }
        ]
    }

    
    var jsonData = JSON.stringify(root)
    alert(jsonData);
    
    function test() {
		$.ajax({
			url : "<%=request.getContextPath()%>/restful/table/modeldata/add",
			dataType: 'json', 
			type : "post",
			data : {
               jsonModelData:jsonData,
               institution_id:null
			},
			success : function(result) {
				var r = $.parseJSON(result);
				if(r.retcode=="1"){
				   alert(r.errorMsg);
				}
			}
		});
	} 
  
     
 </script>

</html>
