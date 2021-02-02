function [feat] = extractFeature(set, featureColName, targetColName)

S = set;
feature = S(:, featureColName);
target = S(:, targetColName);

feature = [feature target];
feature = table2array(feature);

tmpMatrix = {'tmp1' 0 0;
             'tmp2' 1 1;
             'tmp3' 0 0};
         
% for each 'a' in set 'A'
for row = 1:length(feature) 
    val = feature(row, 1);

    % is val in tmpMatrix?
    % what is val of tmpMatrix row 1, col 1?
    % find returns array index of value if found,
    % otherwise 0x1 double empty array
    indexValFound = find(contains(tmpMatrix(:,1), val));
    
    if (indexValFound > 0)
       % Get Yes/No value from row i, col 2 of feature matrix
       targetVal = feature(row, 2);
    
       % if targetVal is 'Yes' increment tmpMatrix row i, col 2,
       % if 'No' increment tmpMatrix row i, col 3.
       yesVal = strcmp(targetVal{1}, 'Yes');
       noVal = strcmp(targetVal{1}, 'No');
       
       if (yesVal)
           tmpMatrix{indexValFound, 2} = tmpMatrix{indexValFound, 2} + 1;
       end
       if (noVal)
          tmpMatrix{indexValFound, 3} = tmpMatrix{indexValFound, 3} + 1;
       end
    else
 	 % add val to end of tmpMatrix
     % init yes/no to 0
      tmpMatrix(length(tmpMatrix)+1,1) = val;
      tmpMatrix{length(tmpMatrix),2} = 0;
      tmpMatrix{length(tmpMatrix),3} = 0;
      
     % increment at row
     % Get Yes/No value from row i, col 2 of feature matrix
     targetVal = feature(row, 2);
    
     % if targetVal is 'Yes' increment tmpMatrix row i, col 2,
     % if 'No' increment tmpMatrix row i, col 3.
     yesVal = strcmp(targetVal{1}, 'Yes');
     noVal = strcmp(targetVal{1}, 'No');
     
     if (yesVal)
         tmpMatrix{length(tmpMatrix), 2} = tmpMatrix{length(tmpMatrix), 2} + 1;
     end
     if (noVal)
         tmpMatrix{length(tmpMatrix), 3} = tmpMatrix{length(tmpMatrix), 3} + 1;
     end
     
    end
    
end

tmpMatrix = tmpMatrix(4:length(tmpMatrix), 1:3);

feat = zeros(size(tmpMatrix, 1), 2);
for i = 1:length(feat)
    feat(i, 1) = tmpMatrix{i, 2};
    feat(i, 2) = tmpMatrix{i, 3};
end

end
